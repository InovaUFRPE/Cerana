<?php

    $erro = isset($_GET['erro']) ? $_GET['erro'] : 0;

?>

<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta charset="utf-8" />
        <link href="../css/crud_style.css" rel="stylesheet" media="all" />
        <script src="../js/crud_functions.js"></script>
        

        <?php
            if($erro == 1){
                echo "<script>alert('Usuário ou senha inválido(s)');</script>";
            } else if($erro == 2){
                echo "<script>alert('Usuário desativado');</script>";
            }
        ?>
       
    </head>
    
    <body>   
    <div class="module">
        <div class="form_page">
            <form class="form_cadastro" name="meu_form_cadastro" method="post" action="validar_acesso.php">

                <div class="logo_img">
                    <img src="../imagens/cerana.png" class="cerana">
                </div>


                <div class="header_wrapper">
                    <h1 class="title">Login</h1>
                </div>


                <div class="title_list">
                    <p class="user">
                        <label class="user_text" for="login_id">Usuário</label>
                    </p>
                    <p class="senha">
                        <label class="senha_text" for="password_check_id">Senha</label>
                    </p>
                </div>
                <div class="input_list">
                    <p class="user">
                        <input class="login_input" type="text" id="login_id" placeholder="Usuário" required="required"
                               name="user" />
                    </p>
                    <p class="senha">
                        <input class="password_check_input" type="password" id="password_check_id" placeholder="*******" required="required"
                               name="senha" />
                    </p>
                </div>

                <p class="submit">
                    <input type="submit" onclick="login();" value="Logar" />
                </p>
            </form>
        </div>
    </div>
    </body>
</html>