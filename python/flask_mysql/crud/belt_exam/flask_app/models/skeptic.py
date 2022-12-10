from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash 
from flask_app.models import user, sighting
mydb = 'belt_exam'

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
        query = "SELECT * FROM skeptics WHERE user_id = %(user_id)s and sighting_id = %(sighting_id)s;"
        results = connectToMySQL(mydb).query_db(query, data)
        print(results)
        if len(results) > 0:
            return cls(results[0]) 
        else: 
            return None

    @classmethod
    def getBySightingID(cls):
        query = "SELECT * FROM skeptics JOIN sightings ON skeptics.sighting_id = %(sighting)s.id;"
        results = connectToMySQL(mydb).query_db(query)
        print(results)
        return len(results)

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM skeptics WHERE user_id = %(user_id)s and sighting_id = %(sighting_id)s;"
        return connectToMySQL(mydb).query_db(query, data)

