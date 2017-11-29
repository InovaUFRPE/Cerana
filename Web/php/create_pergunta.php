<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Nova Pergunta</title>
        <link rel="stylesheet" href="../css/pergunta_style.css">
        <link rel="stylesheet" href="../css/base.css">
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

        <script type="text/javascript">
            
            $(document).ready(function(){

                $('#perguntar_id').click( function(){

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
                                <li><a href="../html/edit_profile.php"><span class="navigation_item">
                                                </span>Editar</a></li>
                                <li><a href="#"><span class="navigation_item"></span>Banco</a></li>
                                <li><a href="#"><span class="navigation_item"></span>Perguntas</a></li>
                                <li><a href="#"><span class="navigation_item"></span>Notificações</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="content_panel">
                        <div class="content_header_wrapper">
                            <h2 class="title">Nova Pergunta</h2>
                        </div>
                        <div class="create_answer">
                            <div id="comment_form">
                                <div class="resposta_title">
                                    <h2><input class="new_question_title" type="text" name="titulo" id="titulo_id" placeholder="Pergunta"></h2>
                                </div>
                                <div class="resposta_info">
                                    <div>
                                        <input type="text" name="familia" id="familia_id" placeholder="Tag1">
                                    </div>
                                    <div>
                                        <input type="text" name="filo" id="filo_id" value="" placeholder="tag2">
                                    </div>
                                    <div>
                                        <input type="text" name="n_cientifio" id="n_cientifico_id" value="" placeholder="tag3">
                                    </div>
                                </div>

                                <div class="resposta_text">
                                    <textarea rows="10" name="comment" id="comment_id" placeholder="Descriçao detalhada"></textarea>
                                </div>
                                <div>
                                    <input class="resposta_submit" type="file" name="'image" value="image">
                                    <button  class="resposta_submit" type="submit" id=perguntar_id name="submit" value="Perguntar">Perguntar</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>