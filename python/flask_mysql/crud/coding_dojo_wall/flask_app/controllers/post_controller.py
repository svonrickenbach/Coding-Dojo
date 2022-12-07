from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import post, user


@app.route('/post', methods=['POST'])
def makepost(): 
    if post.Post.validate_post(request.form):
        post.Post.save(request.form)
    return redirect('/home')

@app.route('/post/edit/<int:post_id>')
def edit_post(post_id):
    session['post_id'] = post_id
    return render_template('post_edit.html', current_user = user.User.getByID({'id' : session['user_id']}), posts = post.Post.get_all_posts_with_creator())

@app.route('/post/edit', methods=['POST'])
def editing_post():
    data = {
        'post_id' : session['post_id'],
        'content' : request.form['content'],
        'user_id' : request.form['user_id']
    }
    if post.Post.validate_post(request.form):
        post.Post.update(data)
    return redirect('/home')

@app.route('/post/delete/<int:post_id>')
def delete_post(post_id): 
    data = { 
        'post_id' : post_id
    }
    post.Post.delete(data)
    return redirect('/home')

