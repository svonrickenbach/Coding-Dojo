from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user
from flask import flash 
import re
mydb = 'coding_dojo_wall_with_comments'

class Post:
    def __init__(self, data):
        self.id = data['id']
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.creator = None

    @classmethod 
    def save(cls, data):
        query = "INSERT INTO posts (content, user_id, created_at, updated_at) VALUES (%(content)s, %(user_id)s, NOW(), NOW());"
        results = connectToMySQL(mydb).query_db(query, data)
        print(results)
        return results

    @classmethod
    def get_all_posts_with_creator(cls):
        query = "SELECT * FROM posts JOIN users ON posts.user_id = users.id;"
        results = connectToMySQL(mydb).query_db(query)
        # print(results)
        posts = []
        for post in results:
            one_post = cls(post)
            one_posts_author_info = {
                'id' : post['users.id'],
                'first_name' : post['first_name'],
                'last_name' : post['last_name'],
                'email' : post['email'],
                'password' : post['password'],
                'created_at' : post['users.created_at'],
                'updated_at' : post['users.updated_at']
            }
            author = user.User(one_posts_author_info)
            one_post.creator = author
            posts.append((one_post))
        return posts

    # @classmethod
    # def get_all_posts_with_creator(cls):
    #     query = "SELECT * FROM posts JOIN users ON posts.user_id = users.id JOIN comments ON comments.post_id = posts.id;"
    #     results = connectToMySQL(mydb).query_db(query)
    #     print(results)
    #     posts = []
    #     for post in results:
    #         one_post = cls(post)
    #         one_posts_author_info = {
    #             'id' : post['users.id'],
    #             'first_name' : post['first_name'],
    #             'last_name' : post['last_name'],
    #             'email' : post['email'],
    #             'password' : post['password'],
    #             'created_at' : post['users.created_at'],
    #             'updated_at' : post['users.updated_at']
    #         }
    #         one_posts_comments = {
    #             'id' : post['comments.id'],
    #             'content' : post['comments.content'],
    #             'created_at' : post['comments.created_at'],
    #             'updated_at' : post['comments.updated_at'],
    #             'creator' : post[comments.user.id]
    #         }
    #         author = user.User(one_posts_author_info)
    #         one_post.creator = author
    #         posts.append((one_post))
    #     return posts

    @classmethod
    def update(cls, data):
        query = "UPDATE posts SET content = %(content)s, updated_at = CURRENT_TIMESTAMP, user_id = %(user_id)s WHERE id = %(post_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM posts WHERE id = %(post_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

    @staticmethod
    def validate_post(post): 
        is_valid = True
        if len(post['content']) < 1: 
            flash("Post cannot be blank!", 'postError')
            is_valid = False 
        return is_valid