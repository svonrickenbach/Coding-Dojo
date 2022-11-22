from flask import Flask, render_template, request, redirect, session 
import random 
app = Flask(__name__)
app.secret_key = "wooowootlewoop"

@app.route('/')
def index():
    session.clear()
    session['button'] = "Submit"
    session["random_num"] = random.randint(1, 100)
    session['counter'] = 1
    print(session["random_num"])
    return render_template('index.html')

@app.route('/guess', methods=['POST'])
def guess():
    if request.form["guess"] == "": 
        return redirect('/')
    elif int(request.form["guess"]) == session["random_num"]:
        session['x'] = "You got it!!!!!"
        session['number'] = f"You took {session['counter']} attempts to get the right number!"
        session['button'] = "Play Again"
        session["color"] = "green"
        session['height'] = "200px"
        session['width'] = "200px"
        session['border'] = "2px solid black"
    elif int(request.form["guess"]) > session["random_num"]:
        session['x'] = "Too High!"
        session['number'] = f"Number of attempts = {session['counter']}"
        session["color"] = "red"
        session['height'] = "200px"
        session['width'] = "200px"
        session['border'] = "2px solid black"
    elif int(request.form["guess"]) < session["random_num"]:
        session['x'] = "Too Low!"
        session['number'] = f"Number of attempts = {session['counter']}"
        session["color"] = "red"
        session['height'] = "200px"
        session['width'] = "200px"
        session['border'] = "2px solid black"
    return redirect('/keepguessin')

@app.route('/keepguessin')
def keep_guessin():
    if 'counter' in session:
        session['counter'] += 1 
        if session['counter'] < 5:
            return render_template('index.html')
        if session['counter'] == 5: 
            session['x'] = "You Loose!"
            return render_template('index.html')
        if session['counter'] > 5:
            return redirect('/')

if __name__=="__main__":
    app.run(port=5001, debug=True)