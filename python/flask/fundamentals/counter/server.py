from flask import Flask, render_template, request, redirect, session 
app = Flask(__name__)
app.secret_key = "oragutangfreefallorange"

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/countup', methods=['Post'])
def count_up():
    session['count'] = request.form['count']
    print(session)
    session['count'] = int(session['count'])
    session['count'] += 1
    return redirect('/')


if __name__=="__main__":
    app.run(port=5001, debug=True)

