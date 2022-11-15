from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def list():
    users = [
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'},
    {'first_name' : 'Michael', 'last_name' : 'Choi'},
    {'first_name' : 'John', 'last_name' : 'Supsupin'},
]
    return render_template('index.html', users_info = users)

if __name__=='__main__':
    app.run(port = 5001, debug = True)