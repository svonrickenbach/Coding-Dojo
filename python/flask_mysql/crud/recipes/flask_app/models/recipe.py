from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash 
from flask_app.models import user
mydb = 'recipe_schema'

class Recipe:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.under = data['under']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_cooked = data['date_cooked']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.creator = None

    @classmethod
    def save(cls, data):
        query = "INSERT INTO recipes (name, under, description, instructions, date_cooked, created_at, updated_at, user_id) VALUES (%(name)s, %(under)s, %(description)s, %(instructions)s, %(date)s, NOW(), NOW(), %(user_id)s);"
        results = connectToMySQL(mydb).query_db(query, data)
        # print(results)
        return results
    
    @classmethod
    def get_all_recipes_with_creator(cls):
        query = "SELECT * FROM recipes JOIN users ON recipes.user_id = users.id;"
        results = connectToMySQL(mydb).query_db(query)
        # print(results)
        recipes = []
        for recipe in results:
            one_recipe = cls(recipe)
            one_recipe_author_info = {
                'id' : recipe['users.id'],
                'first_name' : recipe['first_name'],
                'last_name' : recipe['last_name'],
                'email' : recipe['email'],
                'password' : recipe['password'],
                'created_at' : recipe['users.created_at'],
                'updated_at' : recipe['users.updated_at']
            }
            author = user.User(one_recipe_author_info)
            one_recipe.creator = author
            recipes.append((one_recipe))
        return recipes

    @classmethod
    def get_all_recipes_with_creator(cls):
        query = "SELECT * FROM recipes JOIN users ON recipes.user_id = users.id;"
        results = connectToMySQL(mydb).query_db(query)
        # print(results)
        recipes = []
        for recipe in results:
            one_recipe = cls(recipe)
            one_recipe_author_info = {
                'id' : recipe['users.id'],
                'first_name' : recipe['first_name'],
                'last_name' : recipe['last_name'],
                'email' : recipe['email'],
                'password' : recipe['password'],
                'created_at' : recipe['users.created_at'],
                'updated_at' : recipe['users.updated_at']
            }
            author = user.User(one_recipe_author_info)
            one_recipe.creator = author
            recipes.append((one_recipe))
        return recipes

    @classmethod
    def getByID(cls, data):
        query = "SELECT * FROM recipes WHERE id = %(recipe_id)s;"
        results = connectToMySQL(mydb).query_db(query, data)
        print(results)
        return cls(results[0]) 

    @classmethod
    def getByID_w_user(cls, data):
        query = "SELECT recipes.*, users.first_name AS username FROM recipes JOIN users ON recipes.user_id = users.id WHERE recipes.id = %(recipe_id)s;"
        results = connectToMySQL(mydb).query_db(query, data)
        print(results)
        print(results[0]["username"])
        return results[0]

    @classmethod
    def update(cls, data):
        query = "UPDATE recipes SET name = %(name)s, under = %(under)s, description = %(description)s, instructions = %(instructions)s, date_cooked = %(date_cooked)s, updated_at = CURRENT_TIMESTAMP WHERE id = %(recipe_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM recipes WHERE id = %(recipe_id)s;"
        return connectToMySQL(mydb).query_db(query, data)


    @staticmethod
    def validate_recipe(user): 
        is_valid = True
        if len(user['name']) < 1: 
            flash("must enter a name")
            is_valid = False 
        elif len(user['name']) < 2:
            flash('Recipe name must be longer than two characters')
            is_valid = False
        if len(user['description']) < 1:
            flash("must enter a description")
            is_valid = False
        elif len(user['description']) < 2:
            flash('description must be longer than two characters')
            is_valid = False
        if len(user['instructions']) < 1: 
            flash("must enter instructions")
            is_valid = False 
        elif len(user['instructions']) < 2:
            flash('instructions must be longer than two characters')
            is_valid = False
        if len(user['date']) < 1: 
            flash("must enter a date")
            is_valid = False 
        return is_valid