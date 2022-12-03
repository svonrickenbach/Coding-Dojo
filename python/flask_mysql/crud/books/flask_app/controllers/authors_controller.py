from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import author 
from flask_app.models import book

@app.route('/authors')
def authors():
    authors = author.Author.get_all()
    # for i in authors:
    #     print(i.name)
    return render_template("authors.html", all_authors=authors)

@app.route('/author/add', methods=["POST"])
def add_author(): 
    author.Author.save(request.form)
    return redirect('/authors')

@app.route('/author/<int:author_id>')
def show_one_author(author_id):
    data = {
        "author_id" : author_id
    }
    session['author_id'] = author_id
    return render_template('single_author.html', one_author = author.Author.get_author_with_fav_books(data), books = author.Author.author_favorited_books_excluded(data))

@app.route('/add_book_to_author', methods=["POST"])
def add_book_to_author():
    data = {
        "book_id" : request.form['book_id'],
        "author_id" : session['author_id']
    } 
    author.Author.save_book_to_author(data)
    return redirect(f"/author/{session['author_id']}")