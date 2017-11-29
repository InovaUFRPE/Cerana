<?php

	session_start();

    require_once('db.php');

    $objDb = new db();
    $link = $objDb->conecta_mysql();

    $sql = "UPDATE usuario SET ativo=0 WHERE user='".$_SESSION['user']."' ";
    if(mysqli_query($link, $sql)){
       	header('Location:login.php');
    }else{
        echo "Erro ao registrar o usuário!";
    }

?>	