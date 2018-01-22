from flask import Blueprint, render_template, abort
from jinja2 import TemplateNotFound

questions = Blueprint('questions', __name__,
                    template_folder='templates')

@questions.route('/questions', methods=['GET', 'POST'])
def homepage():
    try:
        return render_template("/questions/Pergunta.html")
    except TemplateNotFound:
        abort(404)

@questions.route('/questions/create_pergunta', methods=['GET', 'POST'])
def dashboard():
    return render_template('/questions/create_pergunta.html')
