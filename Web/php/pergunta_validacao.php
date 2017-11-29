<?php 

	session_start();

	require_once('db.php');

	$titulo = $_POST['titulo_id'];
	$familia = $_POST['familia_id'];
	$filo = $_POST['filo_id'];
	$n_cientifico = $_POST['n_cientifico_id'];
	$comment = $_POST['comment_id'];
	$id_usuario = $_SESSION['id_usuario'];

	$objDb = new db();
    $link = $objDb->conecta_mysql();

    $sql = "INSERT INTO perguntas(id_usuario, pergunta, descricao, tag_familia, tag_filo, tag_cientifico) values($id_usuario,'$titulo','$comment','$familia','$filo','$n_cientifico')";

    mysqli_query($link, $sql);


 ?>