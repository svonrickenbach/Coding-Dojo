from flask import Flask, render_template, redirect, request, session 
from users import User
app = Flask(__name__)
app.secret_key = "hallabaloo"

@app.route('/')
def create(): 
    return render_template ('create.html')

@app.route('/users')
def display(): 
    users = User.get_all()
    # print(users)
    return render_template('index.html', all_users = users)

@app.route('/create_users', methods=["POST"])
def create_user(): 
    data = {
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "email" : request.form["email"],
    }
    User.save(data)
    return redirect('/users')

if __name__=="__main__":
    app.run(port=5001, debug = True)