from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models.dojo import Dojo

@app.route('/dojos')
def index():
    dojos = Dojo.get_all()
    print(dojos)
    return render_template("dojos.html", all_dojos = dojos)

@app.route('/create_dojo', methods=["POST"])
def create_dojo():
    data = {
        "name" : request.form["new_dojo"]
    }
    Dojo.save(data)
    return redirect('/dojos')

@app.route('/dojos/<int:dojo_id>')
def display_dojo(dojo_id): 
    data = {
        "dojo_id" : dojo_id
    }
    one_dojo = Dojo.get_dojo_with_ninjas(data)
    # print(one_dojo[0].name)
    return render_template('display_dojo.html', current_dojo = one_dojo)