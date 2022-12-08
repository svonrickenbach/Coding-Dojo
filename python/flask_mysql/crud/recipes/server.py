from flask_app.controllers import login_reg_controller, user_controller, recipe_controller
from flask_app import app

if __name__=='__main__':
    app.run(port=5001, debug=True)