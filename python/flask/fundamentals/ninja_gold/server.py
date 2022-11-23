from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = "coolfishin75"

@app.route('/')
def home():
    # session.clear()
    return render_template('index.html')

@app.route('/process_money', methods=['POST'])
def process_money():
    if 'total_gold' not in session: 
        session['total_gold'] = 0
    else:
        if 'farm' in request.form:
            if request.form['farm'] == "Find Gold!":
                session['farm_gold'] = random.randint(10, 20)
                if 'total_farm_gold' not in session: 
                    session['total_farm_gold'] = session['farm_gold']
                else:
                    session['total_farm_gold'] = session['total_farm_gold'] + session['farm_gold']
            session['total_gold'] = session['total_gold'] + session['farm_gold']
        elif 'cave' in request.form:
            if request.form['cave'] == "Find Gold!":
                session['cave_gold'] = random.randint(5, 10)
                if 'total_cave_gold' not in session: 
                    session['total_cave_gold'] = session['cave_gold']
                else:
                    session['total_cave_gold'] = session['total_cave_gold'] + session['cave_gold']
            session['total_gold'] = session['total_gold'] + session['cave_gold']
        elif 'house' in request.form:
            if request.form['house'] == "Find Gold!":
                session['house_gold'] = random.randint(2, 5)
                if 'total_house_gold' not in session: 
                    session['total_house_gold'] = session['house_gold']
                else:
                    session['total_house_gold'] = session['total_house_gold'] + session['house_gold']
            session['total_gold'] = session['total_gold'] + session['house_gold']
        elif 'casino' in request.form:
            if request.form['casino'] == "Find Gold!":
                session['casino_gold'] = random.randint(-50, 50)
                if 'total_casino_gold' not in session: 
                    session['total_casino_gold'] = session['casino_gold']
                else:
                    session['total_casino_gold'] = session['total_casino_gold'] + session['casino_gold']
            session['total_gold'] = session['total_gold'] + session['casino_gold']
    print(session)
    return redirect('/')

if __name__=="__main__":
    app.run(port=5001, debug=True)