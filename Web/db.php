<?php 
	
	/* create table usuarios(id int not null primary key auto_increment, usuario varchar(50) not null, email varchar(100) not null, senha varchar(32) not null); */


	class db {
	
		private $host = 'localhost';
		private $usuario = 'root';
		private $senha = '';
		private $database = 'projeto_cerana';

		public function conecta_mysql(){

			$con = mysqli_connect($this->host,$this->usuario,$this->senha,$this->database);

			mysqli_set_charset($con, 'utf8');

			if(mysqli_connect_errno()){
            	echo 'Erro ao tentar se conectar com BD MySQL: ' .mysqli_connect_error();
        	}

        return $con;

		}


	}

?>