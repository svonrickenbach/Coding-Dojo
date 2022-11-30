from flask_app.config.mysqlconnection import connectToMySQL


class Ninja:
    def __init__(self, db_data):
        self.id = db_data['id']
        self.first_name = db_data['first_name']
        self.last_name = db_data['last_name']
        self.age = db_data['age']
        self.created_at = db_data['created_at']
        self.updated_at = db_data['updated_at']

        # self.name = db_data['name']


    @classmethod
    def save(cls, data):
        query = "INSERT INTO ninjas (first_name, last_name, age, created_at, updated_at, dojo_id) VALUES (%(fname)s, %(lname)s, %(age)s, NOW(), NOW(), %(dojo)s);"
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)