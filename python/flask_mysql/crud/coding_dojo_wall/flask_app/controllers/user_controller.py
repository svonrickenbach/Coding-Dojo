from flask_app import app 
from flask import render_template, redirect, request, session, flash 
from flask_app.models import user, post, comment
from datetime import datetime 
dateFormat = "%m/%d/%Y %I:%M %p"

@app.route('/home')
def index():
    if 'user_id' not in session: 
        return redirect('/')
    return render_template("wall.html", current_user = user.User.getByID({'id' : session['user_id']}), posts = post.Post.get_all_posts_with_creator(), dtf = dateFormat, comments = comment.Comment.get_all_comments_with_creator_and_post())
