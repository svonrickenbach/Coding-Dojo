from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import post


@app.route('/post', methods=['POST'])
def makepost(): 
    if post.Post.validate_post(request.form):
        post.Post.save(request.form)
    return redirect('/home')

@app.route('/post/delete/<int:post_id>')
def delete_post(post_id): 
    data = { 
        'post_id' : post_id
    }
    post.Post.delete(data)
    return redirect('/home')

