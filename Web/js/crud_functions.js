var lista_tupla = [];

function cadastrar() {
    var user = document.getElementById("user_id");
    var nome =  document.getElementById("nome_id");
    var senha = document.getElementById("password_id");
    var senhaConfirm = document.getElementById("passwordConfirm_id")
    var email = document.getElementById("email_id");
    var graduacao = document.getElementById("graduacao_id");

    if (isSenhasValidas(senha,senhaConfirm) && isCamposValidos(user,senha,senhaConfirm)) {
        this.lista_tupla.push(user.value);
        this.lista_tupla.push(senha.value);
        this.lista_tupla.push(email.value);
        this.lista_tupla.push(graduacao.value);
        console.log(this.lista_tupla);
        alert('Obrigado sr(a) ' + user.value + ' os seus dados foram Cadastrados com sucesso');
    }
}

function login() {
    var login = document.getElementById("login_id");
    console.log(login);
    var senha = document.getElementById("password_check_id");
    if (login.value == this.lista_tupla[0] && senha.value == this.lista_tupla[1]) {
        alert('Sr(a) ' + login.value + ' logado com sucesso');
    }
    console.log(this.lista_tupla);
}
    
function verificarAlfanumerico(campo){
    var re = /^[A-Za-z0-9]+$/;
    var found = campo.match(re);

    if(found != null){
        return true;
    }else {
        return false;
    }
}

function verificarTamanho(campo){
    if (campo.length > 12 || campo.length < 4){
        return false;
    } else {
        return true;
    }
}


function isSenhasValidas(senha, senhaConfirm){
    if (senha.value === senhaConfirm.value){
        return true;
    } else {
        alert("Senhas diferentes, por favor verifique e tente novamente.");
        return false;
    }
}

function isCamposValidos(user,senha,senhaConfirm){
    if(!verificarAlfanumerico(user.value)){
        alert("Campo usuário inválido.");
    } else if (!verificarAlfanumerico(senha.value)){
        alert("Campo senha inválido.")
    } else if (!verificarTamanho(user.value)){
        alert("Campo usuário inválido.")
    } else if (!verificarTamanho(senha.value)){
        alert("Campo senha inválido.")
    } else {
        verificador = true;
    }
    return verificador;
}
