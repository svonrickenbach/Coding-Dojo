from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, sighting, skeptic

@app.route('/add/skeptic/<int:sighting_id>', methods=['post'])
def add_skeptic(sighting_id):
    if 'user_id' not in session: 
        return redirect('/')
    skeptic.Skeptic.save(request.form)
    return redirect(f'/show/{sighting_id}')

@app.route('/delete/skeptic/<int:sighting_id>', methods=['post'])
def delete_skeptic(sighting_id):
    if 'user_id' not in session: 
        return redirect('/')
    skeptic.Skeptic.delete(request.form)
    return redirect(f'/show/{sighting_id}')



