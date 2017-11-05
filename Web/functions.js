var lista_tupla = [];

function Cadastrar() {
    var nome = document.getElementById("nome_id");
    var senha = document.getElementById("password_id");
    if (nome.value != "" && senha.value != "") {
        lista_tupla.push([nome.value, senha.value]);
    }
    console.log(lista_tupla);
    alert('Obrigado sr(a) ' + nome.value + ' os seus dados foram Cadastrados com sucesso');
}