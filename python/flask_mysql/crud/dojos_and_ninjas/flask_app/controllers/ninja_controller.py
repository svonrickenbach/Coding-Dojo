from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models.ninja import Ninja
from flask_app.models import dojo

@app.route('/ninjas')
def ninja():
    return render_template("ninja.html", dojos=dojo.Dojo.get_all())

@app.route('/add_ninja/', methods=["POST"])
def add_ninja(): 
    data = {
        "dojo" : request.form["dojo.id"],
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "age" : request.form["age"],
    }
    print(data)
    Ninja.save(data)
    return redirect(f"/dojos/{request.form['dojo.id']}")