<?php

    $erro_usuario = isset($_GET['erro_usuario']) ? $_GET['erro_usuario'] : 0;
    $erro_email = isset($_GET['erro_email']) ? $_GET['erro_email'] : 0;
?>


<!DOCTYPE html> 
<html>
    <head>
        <title>--Cadastro--</title>
        <meta charset="utf-8" />
        <link href="../css/crud_style.css" rel="stylesheet" media="all" />
        <script src="../js/crud_functions.js"></script>

    </head>
    <body>
        <div class="module">
        <div class="form_page">
            <form method="post" action="registrar_usuario.php" class="form_cadastro" name="meu_form_cadastro">

                <div class="logo_img">
                    <img src="../imagens/cerana.png" class="cerana">
                </div>


                <div class="header_wrapper">
                    <h1 class="title">Cadastro</h1>
                </div>


                <div class="title_list">
                    <p class="user">
                        <label class="user_text" for="user_id">Usuário</label>
                    </p>
                    <p class="senha">
                        <label class="senha_text" for="password_id">Senha</label>
                    </p>
                    <p class="senhaConfirm">
                        <label class="senhaConfirm_text" for="passwordConfirm_id">Confirmar Senha</label>
                    </p>
                    <p class="email">
                        <label class="email_text" for="email_id">Email</label>
                    </p>
                </div>
                <div class="input_list">
                    <p class="user">
                        <input class="user_input" type="text" id="user_id" placeholder="Usuário" required="required" name="user" />
                        <?php
                            if($erro_usuario){
                                echo '<br/>';
                                echo 'Usuário já existe';
                            }
                        ?>
                    </p>
                    <p class="senha">
                        <input class="senha_input" type="password" id="password_id" placeholder="*******" required="required"
                               name="password" />
                    </p>
                    <p class="senhaConfirm">
                        <input class="senhaConfirm_input" type="password" id="passwordConfirm_id" placeholder="*******" required="required"
                               name="senhaConfirm" />
                    </p>
                    <p class="email">
                        <input class="email_input" type="email" id="email_id" placeholder="fulano@ufrpe.com" name="email" />
                        <?php
                            if($erro_email){
                                echo '<br/>';
                                echo 'Email já existe';
                            }
                        ?>
                    </p>
                </div>

                <p class="submit">
                    <input type="submit" onclick="cadastrar();" value="Cadastrar" />
                </p>
            </form>
        </div>
        </div>

    </body>
</html>