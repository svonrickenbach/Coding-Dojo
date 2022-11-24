from flask import Flask, render_template, request, redirect, session 
from friend import Friend
app = Flask(__name__)
app.secret_key = "jinglejanglebangle"

@app.route('/')
def index():
    friends = Friend.get_all()
    # print(friends)
    return render_template('index.html', all_friends = friends)

@app.route('/create_friend', methods=["POST"])
def create_friend():
    data = {
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "occ" : request.form["occ"]
    }
    Friend.save(data)
    return redirect('/')

if __name__=="__main__":
    app.run(port=5001, debug=True)