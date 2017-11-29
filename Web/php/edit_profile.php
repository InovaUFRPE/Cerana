<?php
    session_start(); 
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Perfil</title>
        <link rel="stylesheet" href="../css/base.css">
        <link rel="stylesheet" href="../css/profile_style.css">
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

        <script type="text/javascript">
            
            $(document).ready(function(){

                $('#btn_salvar_info').click( function(){

                    if($('#titulo_id').val().length > 0){

                        $.ajax({
                            url: 'pergunta_validacao.php',
                            method:'post',
                            data: {titulo_id:$('#titulo_id').val(), familia_id:$('#familia_id').val(), filo_id:$('#filo_id').val(), n_cientifico_id:$('#n_cientifico_id').val(), comment_id:$('#comment_id').val()},
                            success: function(data){
                                alert("Pergunta inserida com sucesso!");
                            }
                        });
                    }
                });
            });

        </script>
    </head>
    <body>
        <div class="container">
            <div class="view_account">
                <section class="module">
                    <div class="module_inner">
                        <div class="side_bar">
                            <div class="user_info">
                                <img class="img_profile" src="../imagens/avatar.png" >
                                <ul class="info_list">
                                    <li class="name" id="tv_nome_info">Pessoa</li>
                                    <li class="label label-info" id="tv_profissao_info">Profissao</li>
                                    <li class="email" id="tv_email_info">Email</li>

                                </ul>
                            </div>
                            <nav class="side_menu">
                                <ul class="navigation">
                                    <li><a href="#"><span class="navigation_item"></span>Perfil</a></li>
                                    <li><a href="#"><span class="navigation_item"></span>Banco</a></li>
                                    <li><a href="#"><span class="navigation_item"></span>Perguntass</a></li>
                                    <li><a href="#"><span class="navigation_item"></span>Notificações</a></li>
                                </ul>
                            </nav>
                        </div>

                        <div class="content_panel">
                            <div class="content_header_wrapper">
                                <h2 class="title">Meu Perfil</h2>
                                <div class="actions">
                                    <button class="btn_nova_questao" id="btn_salvar_info"><i class="btn_text"></i> Salvar informações</button>
                                    <a href=desativar.php><button class="btn_excluir" id="btn_excluir_profile"><i class="btn_text"></i> Excluir Perfil</button></a>
                                </div>
                            </div>

                            <div class="perguntas_list_view">
                                <div class="title_list">
                                    <p class="nome">
                                        <label class="nome_text" for="et_nome">Nome Completo</label>
                                    </p>
                                    <p class="graduacao">
                                        <label class="graduacao_text" for="et_graduacao">Graduação</label>
                                    </p>
                                    <p class="email">
                                        <label class="email_text" for="et_email">Email</label>
                                    </p>
                                </div>
                                <div class="input_list">
                                    <p class="nome">
                                        <input class="nome_input" type="text" id="et_nome" placeholder="Nome Exemplo" required="required"
                                               name="nome" />
                                    </p>
                                    <p class="graduacao">
                                        <input class="graduacao_input" type="text" id="et_graduacao" placeholder="Bacharelado .."
                                               name="graduacao" />
                                    </p>
                                    <p class="email">
                                        <input class="email_input" type="email" id="et_email" placeholder=<?= $_SESSION['email'] ?> name="email" />
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>