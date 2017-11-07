<?php

    require_once('db.php');

    $usuario = $_POST['usuario'];
    $senha = $_POST['senha'];

    $sql = "SELECT * FROM usuarios WHERE user = '$usuario' AND senha = '$senha'";

    $objDb = new db();
    $link = $objDb->conecta_mysql();

    $resultado_id = mysqli_query($link, $sql);

    if($resultado_id){

        $dados_usuario = mysqli_fetch_array($resultado_id);
        
        if(isset($dados_usuario['user'])){
            echo 'usuário existe';
        
        } else{
            header('Location: index.php?erro=1');
        }

    }else{
        
        echo "Erro na execução da consulta, favor entrar em contato com o admin do site";

    }
   
?>