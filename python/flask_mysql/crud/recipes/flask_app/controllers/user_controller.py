from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, recipe
from datetime import datetime 
dateFormat = "%m/%d/%Y %I:%M %p"

@app.route('/recipes')
def index():
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("dashboard.html", current_user = user.User.getByID({'id' : session['user_id']}), recipes = recipe.Recipe.get_all_recipes_with_creator())
