<?php

    require_once('db.php');

    $usuario = $_POST['usuario'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    $objDb = new db();
    $link = $objDb->conecta_mysql();

    $sql = "INSERT INTO usuarios (user, email, senha) VALUES ('$usuario', '$email', '$senha')";

    if(mysqli_query($link, $sql)){
        echo "Usuário registrado com sucesso!";
    }else{
        echo "Erro ao registrar o usuário!";
    }

?>