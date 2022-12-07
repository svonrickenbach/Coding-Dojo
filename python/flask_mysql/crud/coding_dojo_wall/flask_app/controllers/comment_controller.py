from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import comment


@app.route('/comment', methods=['POST'])
def post_comment(): 
    if comment.Comment.validate_post(request.form):
        comment.Comment.save(request.form)
    return redirect('/home')

@app.route('/comment/delete/<int:comment_id>')
def delete_comment(comment_id): 
    data = { 
        'comment_id' : comment_id
    }
    comment.Comment.delete(data)
    return redirect('/home')

