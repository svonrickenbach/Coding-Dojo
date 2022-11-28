from flask import Flask, render_template, redirect, request, session 
from users import User
from mysqlconnection import MySQLConnection

app = Flask(__name__)
app.secret_key = "hallabaloo"

@app.route('/')
def create(): 
    return render_template ('create.html')

@app.route('/users')
def display(): 
    users = User.get_all()
    # print(users)
    # user = User.get_all()[1]
    # print(user)
    return render_template('read.html', all_users = users)

@app.route('/create_users', methods=["POST"])
def create_user(): 
    data = {
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "email" : request.form["email"],
    }
    User.save(data)
    MySQLConnection.query_db
    return redirect('/users')

@app.route('/users/<int:id>')
def display_one_user(id):
    for user in User.get_all():
        index = user.id
        if id == index:
            user1 = user 
    return render_template('read_one.html', current_user = user1)


@app.route('/users/<int:id>/edit')
def edit_page(id):
    for user in User.get_all():
        index = user.id
        if id == index:
            user1 = user 
    return render_template("edit.html", id1 = id, current_user = user1)

@app.route('/edit/<int:id>', methods=["POST"])
def edit(id):
    data = {
    "fname" : request.form["fname"],
    "lname" : request.form["lname"],
    "email" : request.form["email"],
    "current_id" : id
    }
    User.update(data)
    return redirect(f'/users/{id}')

@app.route('/delete/<int:id>')
def delete(id):
    data = {
    "current_id" : id
    }
    User.delete(data)
    return redirect('/users')


if __name__=="__main__":
    app.run(port=5001, debug = True)