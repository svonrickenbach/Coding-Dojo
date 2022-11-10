from flask import Flask
app = Flask (__name__)

@app.route('/')
def hello_world():
    return "Hello World!"

@app.route('/dojo')
def dojo():
    return 'Dojo!'

@app.route('/say/<name>')
def say_hi(name):
    return "Hi " + str(name.capitalize()) + "!"

@app.route('/repeat/<num>/<word>')
def say_it_a_lot(num, word):
    return str((word + " ")) * int(num)   #Included the str cast to satisfy the second Ninja Bonus, but it's unnecessary because it would be a string regardless, so I don't really get the point of that exercise. 

@app.route('/', defaults={'path': ''})
@app.route('/<path:path>')
def catch_all(path):
    return 'Sorry! No response. Try again.'


if __name__=="__main__":
    app.run(port=5001, debug = True)

