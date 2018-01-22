from flask import Blueprint, render_template, abort
from jinja2 import TemplateNotFound

home = Blueprint('home', __name__,
                    template_folder='templates')

@home.route('/', methods=['GET', 'POST'])
def homepage():
    try:
        return render_template("home/index-bootstrap.html")
    except TemplateNotFound:
        abort(404)

@home.route('/dashboard', methods=['GET', 'POST'])
def dashboard():
    return render_template('teste.html')