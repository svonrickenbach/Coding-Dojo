from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash 
from flask_app.models import user, skeptic
mydb = 'belt_exam'

class Sighting:
    def __init__(self, data):
        self.id = data['id']
        self.location = data['location']
        self.what_happened = data['what_happened']
        self.date_of_sighting = data['date_of_sighting']
        self.number_of_sasquatches = data['number_of_sasquatches']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.creator = None
        self.skeptic = None


    @classmethod
    def save(cls, data):
        query = "INSERT INTO sightings (location, what_happened, date_of_sighting, number_of_sasquatches, created_at, updated_at, user_id) VALUES (%(location)s, %(what_happened)s, %(date_of_sighting)s, %(number_of_sasquatches)s, NOW(), NOW(), %(user_id)s);"
        results = connectToMySQL(mydb).query_db(query, data)
        # print(results)
        return results

    @classmethod
    def get_all_sightings_with_creator(cls):
        query = "SELECT * FROM sightings JOIN users ON sightings.user_id = users.id;"
        results = connectToMySQL(mydb).query_db(query)
        print(results)
        sightings = []
        for sighting in results:
            one_sighting = cls(sighting)
            one_sighting_author_info = {
                'id' : sighting['users.id'],
                'first_name' : sighting['first_name'],
                'last_name' : sighting['last_name'],
                'email' : sighting['email'],
                'password' : sighting['password'],
                'created_at' : sighting['users.created_at'],
                'updated_at' : sighting['users.updated_at']
            }
            author = user.User(one_sighting_author_info)
            one_sighting.creator = author
            sightings.append((one_sighting))
        return sightings

    # @classmethod
    # def get_all_sightings_with_creator_and_skeptics(cls):
    #     query = "SELECT * FROM sightings JOIN users ON sightings.user_id = users.id LEFT JOIN skeptics ON skeptics.sighting_id = sightings.id;"
    #     results = connectToMySQL(mydb).query_db(query)
    #     print(results)
    #     sightings = []
    #     for sighting in results:
    #         one_sighting = cls(sighting)
    #         one_sighting_author_info = {
    #             'id' : sighting['users.id'],
    #             'first_name' : sighting['first_name'],
    #             'last_name' : sighting['last_name'],
    #             'email' : sighting['email'],
    #             'password' : sighting['password'],
    #             'created_at' : sighting['users.created_at'],
    #             'updated_at' : sighting['users.updated_at']
    #         }
    #         author = user.User(one_sighting_author_info)
    #         one_sighting.creator = author
    #         one_sighting_sketpic_info = {
    #             'id' : sighting['skeptics.id'],
    #             'user_id' : sighting['skeptics.user_id'],
    #             'sighting_id' : sighting['sighting_id'],
    #         }
    #         a_skeptic = skeptic.Skeptic(one_sighting_sketpic_info)
    #         alist = []
    #         alist.append(a_skeptic)
    #         one_sighting.skeptic = len(alist)
    #         sightings.append((one_sighting))
    #     return sightings


    @classmethod
    def getByID_w_user(cls, data):
        query = "SELECT sightings.*, users.first_name, users.last_name FROM sightings JOIN users ON sightings.user_id = users.id WHERE sightings.id = %(sighting_id)s;"
        results = connectToMySQL(mydb).query_db(query, data)
        # print(results)
        this_sighting = cls(results[0])
        this_sighting.creator = []
        this_sighting.creator.append(results[0]['first_name'])
        this_sighting.creator.append(results[0]['last_name'])
        # print(this_sighting.creator)
        return this_sighting

    @classmethod
    def update(cls, data):
        query = "UPDATE sightings SET location = %(location)s, what_happened = %(what_happened)s, date_of_sighting = %(date_of_sighting)s, number_of_sasquatches = %(number_of_sasquatches)s, updated_at = CURRENT_TIMESTAMP WHERE id = %(sighting_id)s;"
        return connectToMySQL(mydb).query_db(query, data)


    @classmethod
    def delete(cls, data):
        query = "DELETE FROM sightings WHERE id = %(sighting_id)s;"
        return connectToMySQL(mydb).query_db(query, data)


    @staticmethod
    def validate_sighting(user): 
        is_valid = True
        if len(user['location']) < 1: 
            flash("must enter a location")
            is_valid = False 
        if len(user['what_happened']) < 1:
            flash("must describe what happened")
            is_valid = False
        if len(user['date_of_sighting']) < 1: 
            flash("must enter a date")
            is_valid = False 
        if int(user['number_of_sasquatches']) < 1: 
            flash("must enter a number of sasquatches")
            is_valid = False 
        return is_valid