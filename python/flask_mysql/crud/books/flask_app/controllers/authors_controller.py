from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import author 

@app.route('/authors')
def authors():
    authors = author.Author.get_all()
    for i in authors:
        print(i.name)
    return render_template("authors.html", all_authors=authors)

@app.route('/author/add', methods=["POST"])
def add_author(): 
    author.Author.save(request.form)
    return redirect('/authors')

@app.route('/author/<int:author_id>')
def show_one_author():
    pass