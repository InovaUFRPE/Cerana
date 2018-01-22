from flask import Blueprint, render_template, abort
from jinja2 import TemplateNotFound

profile = Blueprint('profile', __name__,
                    template_folder='templates')


@profile.route('/profile')
def view_profile():
    try:
        return render_template('user/profile.html')
    except TemplateNotFound:
        abort(404)


@profile.route('/profile/edit_profile')
def update_profile():
    try:
        return render_template('user/edit_profile.html')
    except TemplateNotFound:
        abort(404)