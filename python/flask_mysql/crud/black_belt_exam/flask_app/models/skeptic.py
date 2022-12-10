from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash 
from flask_app.models import user, sighting
mydb = 'black_belt_exam'

class Skeptic:
    def __init__(self, data):
        self.id = data['id']
        self.user_id = data['user_id']
        self.sighting_id = data['sighting_id']
        self.user = None
        self.sighting = None

    @classmethod
    def save(cls, data):
        query = "INSERT INTO skeptics (user_id, sighting_id) VALUES (%(user_id)s, %(sighting_id)s);"
        results = connectToMySQL(mydb).query_db(query, data)
        # print(results)
        return results

    @classmethod
    def getByID(cls, data):
        query = "SELECT * FROM skeptics WHERE user_id = %(user_id)s;"
        results = connectToMySQL(mydb).query_db(query, data)
        print(results)
        if len(results) > 0:
            return cls(results[0]) 
        else: 
            return None

    # @classmethod
    # def get_all_skeptics_with_user_and_sighting(cls):
    #     query = "SELECT * FROM comments JOIN users ON comments.user_id = users.id JOIN posts ON comments.post_id = posts.id;"
    #     results = connectToMySQL(mydb).query_db(query)
    #     # print(results)
    #     skeptics = []
    #     for row in results:
    #         one_skeptic = cls(row)
    #         one_sketpic_user_info = {
    #             'id' : row['users.id'],
    #             'first_name' : row['first_name'],
    #             'last_name' : row['last_name'],
    #             'email' : row['email'],
    #             'password' : row['password'],
    #             'created_at' : row['users.created_at'],
    #             'updated_at' : row['users.updated_at']
    #         }
    #         one_skeptic_sighting_info = {
    #             'id' : row['sightings.id'],
    #             'location' : row['location'],
    #             'what_happened' : row['what_happened'],
    #             'date_of_sighting' : row['date_of_sighting'],
    #             'number_of_sasquatches' : row['number_of_sasquatches'],
    #             'created_at' :row['sightings.created_at'],
    #             'updated_at' : row['sightings.updated_at']
    #         }
    #         author = user.User(one_sketpic_user_info)
    #         one_skeptic.user = author
    #         associated_sighting = sighting.Sighting(one_skeptic_sighting_info)
    #         one_skeptic.sighting = associated_sighting
    #         skeptics.append((one_skeptic))
    #     return skeptics

    # @classmethod
    # def getBySightingID(cls):
    #     query = "SELECT * FROM skeptics JOIN sightings ON skeptics.sighting_id = %(sighting)s.id;"
    #     results = connectToMySQL(mydb).query_db(query)
    #     print(results)
    #     return len(results)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM skeptics WHERE user_id = %(user_id)s and sighting_id = %(sighting_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

