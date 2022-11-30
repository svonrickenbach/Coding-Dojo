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

@app.route('/ninjas/edit/<int:ninjas_id>')
def edit_page(ninjas_id):
    data = {
        "ninja_id" : ninjas_id
    }
    Ninja.get_one(data)
    print(Ninja.get_one(data).id)
    return render_template('edit.html', dojos=dojo.Dojo.get_all(), ninja=Ninja.get_one(data))

@app.route('/ninjas/editing/<int:user_id>', methods=["POST"])
def edit(user_id):
    data = {
        "current_id" : user_id,
        "dojo" : request.form["dojo.id"],
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "age" : request.form["age"],
    }
    Ninja.update(data)
    return redirect(f"/dojos/{request.form['dojo.id']}")

@app.route('/delete/<int:current_dojo_id>/<int:ninja_id>')
def delete(ninja_id, current_dojo_id): 
    data = {
        "current_id": ninja_id
    }
    Ninja.delete(data)
    current_dojo_id
    return redirect(f"/dojos/{current_dojo_id}")