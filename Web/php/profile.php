<?php

    session_start();  
    if(!isset($_SESSION['user'])){
        header('location: login.php?erro=1');
    } 
?>

<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="../css/base.css">
        <link rel="stylesheet" href="../css/profile_style.css">
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
                                    <li><a href="#"><span class="navigation_item"></span>Perguntass</a></li>
                                    <li><a href="#"><span class="navigation_item"></span>Notificações</a></li>
                                </ul>
                            </nav>
                        </div>

                        <div class="content_panel">
                            <div class="content_header_wrapper">
                                <h2 class="title">Minhas Questões</h2>
                                <div class="actions">
                                    <a href=create_pergunta.php><button class="btn_nova_questao" id="btn_new_question"><i class="btn_text" ></i> Nova Questão</button></a>
                                    <a href=sair.php><button class="btn_nova_questao" id="btn_new_question"><i class="btn_text" ></i>Sair</button></a>
                                       
                                </div>
                            </div>

                            <div class="perguntas_list_view">
                                <div class="table_responsive_wrapper">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th class="type"></th>
                                            <th class="perguntas">Pergunta</th>
                                            <th class="data">Data</th>
                                            <th class="respostas">Respostas</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>
                                        <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>                                    <tr>
                                            <td class="type"><i class="pergunta_item"></i></td>
                                            <td class="perguntas"><a href="#">pergunta</a></td>
                                            <td class="data">Sep 23, 2015</td>
                                            <td class="respostas">18</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>