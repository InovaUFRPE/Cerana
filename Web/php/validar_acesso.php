<?php

    session_start();

    require_once('db.php');

    $usuario = $_POST['user'];
    $senha = md5($_POST['senha']);

    $sql = "SELECT id,user,email,ativo FROM usuario WHERE user = '$usuario' AND senha = '$senha'";

    $objDb = new db();
    $link = $objDb->conecta_mysql();

    $resultado_id = mysqli_query($link, $sql);

    if($resultado_id){

        $dados_usuario = mysqli_fetch_array($resultado_id);
        
        if(isset($dados_usuario['user'])){
            if($dados_usuario['ativo'] == 0){
                header('Location:login.php?erro=2');
                alert('Usuário desativado'); 
            }

            $_SESSION['id_usuario'] = $dados_usuario['id'];
            $_SESSION['user'] = $dados_usuario['user'];
            $_SESSION['email'] = $dados_usuario['email'];

            header('Location:profile.php');
        	
        
        } else{
            header('Location:login.php?erro=1');
        	alert('teste');
        }

    }else{
        
        echo "Erro na execução da consulta, favor entrar em contato com o admin do site";

    }
   
?>