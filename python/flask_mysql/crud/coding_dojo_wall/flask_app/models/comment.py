from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user, post
from flask import flash 
import re
mydb = 'coding_dojo_wall_with_comments'

class Comment:
    def __init__(self, data):
        self.id = data['id']
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.creator = None
        self.post = None

    @classmethod 
    def save(cls, data):
        query = "INSERT INTO comments (content, user_id, post_id, created_at, updated_at) VALUES (%(content)s, %(user_id)s, %(post_id)s, NOW(), NOW());"
        results = connectToMySQL(mydb).query_db(query, data)
        # print(results)
        return results

    @classmethod
    def get_all_comments_with_creator_and_post(cls):
        query = "SELECT * FROM comments JOIN users ON comments.user_id = users.id JOIN posts ON comments.post_id = posts.id;"
        results = connectToMySQL(mydb).query_db(query)
        # print(results)
        comments = []
        for row in results:
            one_comment = cls(row)
            one_comment_author_info = {
                'id' : row['users.id'],
                'first_name' : row['first_name'],
                'last_name' : row['last_name'],
                'email' : row['email'],
                'password' : row['password'],
                'created_at' : row['users.created_at'],
                'updated_at' : row['users.updated_at']
            }
            one_comment_post_info = {
                'id' : row['posts.id'],
                'content' : row['posts.content'],
                'created_at' : row['posts.created_at'],
                'updated_at' : row['posts.updated_at'],
                'creator' : row['posts.user_id']
            }
            author = user.User(one_comment_author_info)
            one_comment.creator = author
            associated_post = post.Post(one_comment_post_info)
            one_comment.post = associated_post
            comments.append((one_comment))
        return comments

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM comments WHERE id = %(comment_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

    @staticmethod
    def validate_post(comment): 
        is_valid = True
        if len(comment['content']) < 1: 
            flash("Comment cannot be blank!", 'commentError')
            is_valid = False 
        return is_valid