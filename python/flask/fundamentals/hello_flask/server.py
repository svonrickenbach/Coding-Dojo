from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/')          # The "@" decorator associates this route with the function immediately following
def hello_world():
    return render_template('index.html', phrase='hello', times=5)  # Return the string 'Hello World!' as a response

@app.route('/success')
def success():
    return "success"

@app.route('/hello/<name>')
def hello(name):
    print(name)
    return "Hello, " + name 

@app.route('/users/<username>/<id>')
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id

@app.route('/lists')
def render_lists():
    student_info = [
        {'name' : 'Michael', 'age' : 35},
        {'name' : 'John', 'age' : 30},
        {'name' : 'Mark', 'age' : 25},
        {'name' : 'KB', 'age' : 27},
    ]
    return render_template("lists.html", random_numbers = [3,1,5], students = student_info)

@app.route('/', defaults={'path': ''})
@app.route('/<path:path>')
def catch_all(path):
    return 'Invalid URL.'

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(port=5001, debug=True)    # Run the app in debug mode.

