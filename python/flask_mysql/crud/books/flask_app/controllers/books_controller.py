from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import book

@app.route('/books')
def books():
    books = book.Book.get_all()
    return render_template("books.html", all_books=books)

@app.route('/book/add', methods=["POST"])
def add_book(): 
    book.Book.save(request.form)
    return redirect('/books')
