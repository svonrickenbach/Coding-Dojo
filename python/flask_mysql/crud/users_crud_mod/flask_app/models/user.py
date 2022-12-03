from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash 
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-0._-]+\.[a-zA-Z]+$')

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL('users_schema').query_db(query)
        # print(results)
        users = []
        for user in results:
            # print(user)
            users.append(cls(user))
        return users

    @classmethod
    def save(cls, data):
        query = "INSERT INTO users (first_name, last_name, email, created_at, updated_at) VALUES (%(fname)s, %(lname)s, %(email)s, NOW(), NOW());"
        return connectToMySQL('users_schema').query_db(query, data)

    @classmethod
    def update(cls, data):
        query = "UPDATE users SET first_name = %(fname)s, last_name = %(lname)s, email = %(email)s, updated_at = CURRENT_TIMESTAMP WHERE id = %(current_id)s;"
        return connectToMySQL('users_schema').query_db(query, data)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM users WHERE id = %(current_id)s;"
        return connectToMySQL('users_schema').query_db(query, data)

    @staticmethod
    def validate_user(user): 
        is_valid = True
        if len(user['fname']) < 1: 
            flash("must enter a first name")
            is_valid = False 
        if len(user['lname']) < 1:
            flash("must enter a last name")
            is_valid = False
        if not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!")
            is_valid = False
        return is_valid