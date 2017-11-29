<?php

    require_once('db.php');

    $usuario = $_POST['user'];
    $email = $_POST['email'];
    $senha = md5($_POST['password']);

    $objDb = new db();
    $link = $objDb->conecta_mysql();

    $usuario_existe = false;
    $email_existe = false;

    //verificar se o usuário já existe
    $sql = "SELECT * FROM usuario WHERE user = '$usuario' ";
    if($resultado_id = mysqli_query($link, $sql)){

        $dados_usuario = mysqli_fetch_array($resultado_id);
        if(isset($dados_usuario['user'])){
        	$usuario_existe = true;
        }
    }

    //verificar se o e-mail já existe
    $sql = "SELECT * FROM usuario WHERE email = '$email' ";
    if($resultado_id = mysqli_query($link, $sql)){

        $dados_usuario = mysqli_fetch_array($resultado_id);

        if(isset($dados_usuario['email'])){
        	$email_existe = true;
        }
	}

	if($usuario_existe || $email_existe){
		
		$retorno_get = '';

		if($usuario_existe){
			$retorno_get.= "erro_usuario=1&";
		}

		if($email_existe){
			$retorno_get.= "erro_email=1&";
		}

		header('Location:cadastro.php?'.$retorno_get);
		die();
	}

    $sql = "INSERT INTO usuario (user, email, senha) VALUES ('$usuario', '$email', '$senha')";

    if(mysqli_query($link, $sql)){
        header('Location:login.php');
        //echo "<script>alert('Usuário cadastrado com sucesso.');</script>";
    }else{
        echo "Erro ao registrar o usuário!";
    }

?>