from flask import Flask, render_template, request, redirect, session 
app = Flask(__name__)
app.secret_key = "oragutangfreefallorange"

@app.route('/')
def index():
    if 'counter' not in session:
        session['counter'] = 0
    if 'page_visits' in session: 
        session['page_visits'] += 1 
    else: 
        session['page_visits'] = 1 
    return render_template ('index.html')

@app.route('/destroy_session')
def destroy():
    session.pop('page_visits')
    return redirect('/')

@app.route('/plus2', methods=['POST'])
def plustwo():
    if 'counter' in session:
        if request.form['button'] == 'Add 2':
            session['counter'] += 2 
        if request.form['button'] == 'reset':
            session.pop('counter'), session.pop('page_visits')
        elif request.form['num']:
            session['counter'] = session['counter'] + int(request.form['num']) - 2
    return redirect('/')


if __name__=="__main__":
    app.run(port=5001, debug=True)

