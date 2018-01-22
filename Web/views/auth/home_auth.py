from flask import Blueprint, render_template, abort, redirect, url_for, flash
from jinja2 import TemplateNotFound
from flask_login import login_user, logout_user

from model.user_object import UserObj
from .forms import RegistrationForm, LoginForm
from controllers.user_controller import validate_login, validate_sing_up

auth = Blueprint('auth', __name__,
                    template_folder='templates')

@auth.route('/auth/login', methods=['GET', 'POST'])
def login():
    error = None
    form = LoginForm()
    if form.validate_on_submit():
        valida = validate_login(form.email.data, form.password.data)
        if not valida:
            error = 'Dados inválidos. Por favor tente novamente.'
            return error
        else:
            login_user(valida[1])
            return redirect(url_for('home.dashboard'))
    try:
        return render_template('auth/login-bootstrap.html', form=form, title="Login", error=error)
    except TemplateNotFound:
        abort(404)



@auth.route('/auth/register', methods=['GET', 'POST'])
def register():
    form = RegistrationForm()
    if form.validate_on_submit():
        user = UserObj(form.email.data, form.password.data)
        valida = validate_sing_up(user)
        if valida:
            flash('Você se cadastrou com sucesso!')
            return redirect(url_for('auth.login'))
        else:
            flash('usuario ja cadastrado!')
    try:
        return render_template("auth/register-bootstrap.html", form=form, title="Register")
    except TemplateNotFound:
        abort(404)

@auth.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('home.homepage'))
