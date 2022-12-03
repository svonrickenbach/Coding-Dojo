from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import book
from flask_app.models import author

@app.route('/books')
def books():
    books = book.Book.get_all()
    return render_template("books.html", all_books=books)

@app.route('/book/add', methods=["POST"])
def add_book(): 
    book.Book.save(request.form)
    return redirect('/books')

@app.route('/book/<int:book_id>')
def show_one_book(book_id): 
    data = {
        "book_id" : book_id
    }
    session['book_id'] = book_id
    one_book = book.Book.get_book_with_author(data)
    print(one_book.title)
    return render_template('single_book.html', one_book = book.Book.get_book_with_author(data), authors = book.Book.book_favorited_authors_excluded(data))

@app.route('/add_author_to_book', methods=["POST"])
def add_author_to_book():
    data = {
        "author_id" : request.form['author_id'],
        "book_id" : session['book_id']
    }
    book.Book.save_author_to_book(data)
    return redirect(f"/book/{session['book_id']}")