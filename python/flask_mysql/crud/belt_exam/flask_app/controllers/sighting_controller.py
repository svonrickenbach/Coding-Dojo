from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, sighting, skeptic
from datetime import datetime 
dateFormat = "%m/%d/%Y %I:%M %p"
dateFormat_no_time = "%Y-%m-%d" 
dateFormat_full_month = "%B %d %Y"

@app.route('/new/sighting')
def report_sighting():
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("report_a_sighting.html", current_user = user.User.getByID({'id' : session['user_id']}))

@app.route('/new/sighting/add', methods=['post'])
def add_sighting():
    if 'user_id' not in session: 
        return redirect('/')
    elif sighting.Sighting.validate_sighting(request.form):
        sighting.Sighting.save(request.form)
        return redirect('/dashboard')
    return redirect('/new/sighting')


@app.route('/edit/<int:sighting_id>')
def edit_sighting(sighting_id):
    session['sighting_id'] = sighting_id
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("edit.html", current_user = user.User.getByID({'id' : session['user_id']}), sightings = sighting.Sighting.getByID_w_user({'sighting_id' : sighting_id}), dtf = dateFormat_no_time)

@app.route('/sighting/edit', methods=['post'])
def edit():
    if 'user_id' not in session: 
        return redirect('/')
    elif sighting.Sighting.validate_sighting(request.form):
        data = {
        'sighting_id' : session['sighting_id'],
        'location' : request.form['location'],
        'what_happened' : request.form['what_happened'],
        'date_of_sighting' : request.form['date_of_sighting'],
        'number_of_sasquatches' : request.form['number_of_sasquatches'],
    }
        sighting.Sighting.update(data)
        return redirect('/dashboard')
    return redirect(f"/edit/{session['sighting_id']}")

@app.route('/show/<int:sighting_id>')
def show_sighting(sighting_id): 
    if 'user_id' not in session: 
        return redirect('/')
    return render_template('view_sighting.html', current_user = user.User.getByID({'id' : session['user_id']}), sightings = sighting.Sighting.getByID_w_user({'sighting_id' : sighting_id}), dtf = dateFormat_full_month, skeptic = skeptic.Skeptic.getByID({'user_id' : session['user_id'], 'sighting_id' : sighting_id}))

@app.route('/sighting/delete/<int:sightings_id>')
def delete(sightings_id):
    data = {
        'sighting_id' : sightings_id 
    }
    if 'user_id' not in session: 
        return redirect('/')
    sighting.Sighting.delete(data)
    return redirect('/dashboard')