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

    @classmethod
    def get_one(cls,data):
        query  = "SELECT * FROM ninjas WHERE id = %(ninja_id)s;"
        result = connectToMySQL('dojos_and_ninjas_schema').query_db(query,data)
        return cls(result[0])


    @classmethod
    def update(cls, data):
        query = "UPDATE ninjas SET first_name = %(fname)s, last_name = %(lname)s, age = %(age)s, updated_at = CURRENT_TIMESTAMP, dojo_id = %(dojo)s WHERE id = %(current_id)s;"
        return connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)