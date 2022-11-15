from flask import Flask, render_template; import math
app = Flask(__name__)

@app.route('/')
def eight_by():
    return render_template("index.html", x_axis = 8, y_axis = 8)

@app.route('/<int:x_axis>')
def x_by(x_axis):
    return render_template("index.html", x_axis = x_axis, y_axis = 8)

@app.route('/<int:x>/<int:y>')
def x_and_y(x, y):
    return render_template("index.html", x_axis = x, y_axis = y)

@app.route('/<int:x>/<int:y>/<color1>/<color2>')
def x_and_y_and_color(x, y, color1, color2):
    return render_template("index.html", x_axis = x, y_axis = y, color1 = color1, color2 = color2)

if __name__=="__main__":
    app.run(port = 5001, debug = True)