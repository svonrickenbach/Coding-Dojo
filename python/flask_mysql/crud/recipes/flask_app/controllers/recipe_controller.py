from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, recipe
from datetime import datetime 
dateFormat = "%m/%d/%Y %I:%M %p"
dateFormat_no_time = "%Y-%m-%d" 


@app.route('/recipes/new')
def new_recipe():
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("create_recipe.html", current_user = user.User.getByID({'id' : session['user_id']}))


@app.route('/recipes/new/add', methods=['post'])
def add_recipe():
    if 'user_id' not in session: 
        return redirect('/')
    elif recipe.Recipe.validate_user(request.form):
        recipe.Recipe.save(request.form)
        return redirect('/recipes')
    return redirect('/recipes/new')

@app.route('/recipes/edit/<int:recipe_id>')
def edit_recipe(recipe_id):
    session['recipe_id'] = recipe_id
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("edit_recipe.html", current_user = user.User.getByID({'id' : session['user_id']}), recipes = recipe.Recipe.getByID({'recipe_id' : recipe_id}), dtf = dateFormat_no_time)

@app.route('/recipes/edit', methods=['post'])
def edit():
    if 'user_id' not in session: 
        return redirect('/')
    elif recipe.Recipe.validate_user(request.form):
        data = {
        'recipe_id' : session['recipe_id'],
        'name' : request.form['name'],
        'under' : request.form['under'],
        'description' : request.form['description'],
        'instructions' : request.form['instructions'],
        'date_cooked' : request.form['date']
    }
        recipe.Recipe.update(data)
        return redirect('/recipes')
    return redirect('/recipes/new')

@app.route('recipes/<int:recipe_id>')
def view_recipe(): 
    if 'user_id' not in session: 
        return redirect('/')
    