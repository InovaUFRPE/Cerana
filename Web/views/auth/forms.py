from flask_wtf import FlaskForm
from wtforms import PasswordField, StringField, SubmitField, ValidationError
from wtforms.validators import DataRequired, Email, EqualTo


class RegistrationForm(FlaskForm):
    """
    Form para cadastro
    """
    email = StringField('Email', validators=[DataRequired(), Email()])
    first_name = StringField('Nome', validators=[DataRequired()])
    last_name = StringField('Sobrenome', validators=[DataRequired()])
    password = PasswordField('Senha', validators=[
                                        DataRequired(),
                                        EqualTo('confirm_password')
                                        ])
    confirm_password = PasswordField('Confirmar Senha')
    submit = SubmitField('Cadastrar')


class LoginForm(FlaskForm):
    """
    Form para login
    """
    email = StringField('Email', validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    submit = SubmitField('Login')