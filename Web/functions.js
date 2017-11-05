var lista_tupla = [];

function Cadastrar() {
    var nome =  document.getElementById("nome_id");
    var senha = document.getElementById("password_id");
    var email = document.getElementById("email_id");
    var graduacao = document.getElementById("graduacao_id");
    if (nome.value != "" && senha.value != "") {
        this.lista_tupla.push(nome.value);
        this.lista_tupla.push(senha.value);
        this.lista_tupla.push(email.value);
        this.lista_tupla.push(graduacao.value);
    }
    console.log(this.lista_tupla);
    alert('Obrigado sr(a) ' + nome.value + ' os seus dados foram Cadastrados com sucesso');
}

function Login() {
    var login = document.getElementById("login_id");
    console.log(login);
    var senha = document.getElementById("password_check_id");
    if (login.value == this.lista_tupla[0] && senha.value == this.lista_tupla[1]) {
        alert('Sr(a) ' + login.value + ' logado com sucesso');
    }
    console.log(this.lista_tupla);
}