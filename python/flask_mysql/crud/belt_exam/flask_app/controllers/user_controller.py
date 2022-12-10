from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, sighting
from datetime import datetime 
dateFormat = "%m/%d/%Y"

@app.route('/dashboard')
def index():
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("dashboard.html", current_user = user.User.getByID({'id' : session['user_id']}), sightings = sighting.Sighting.get_all_sightings_with_creator(), dtf = dateFormat)
