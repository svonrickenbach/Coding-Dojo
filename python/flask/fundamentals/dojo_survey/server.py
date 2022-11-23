from flask import Flask, render_template, redirect, request, session 
app = Flask(__name__)
app.secret_key = "krungburger"

@app.route('/')
def form():
    session.clear()
    return render_template('index.html')

@app.route('/form_submit', methods=['POST'])
def submit():
    session['name'] = request.form['name']
    session['dojo_location'] = request.form['dojo']
    session['favorite_language'] = request.form['language']
    session['comments'] = request.form['comments']
    session['CSS_HATE'] = request.form['CSS_Hate']
    if 'accept' in request.form:
        session['absolute_worst'] = True
    else: 
        session['absolute_worst'] = False
    return redirect('/results')

@app.route('/results')
def results():
    return render_template('results.html')

if __name__=="__main__":
    app.run(port=5001, debug = True)