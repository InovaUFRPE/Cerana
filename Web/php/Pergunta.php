<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Pergunta</title>
        <link rel="stylesheet" href="../css/base.css">
        <link rel="stylesheet" href="../css/pergunta_style.css">
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
                            <div class="question_card">
                                <div class="question_title">
                                    <h2>Titulo da Pergunta</h2>
                                </div>
                                <div class="question_content">
                                    <p>
                                       Content block
                                    </p>
                                </div>
                                <div class="question_image">
                                    <img src="../imagens/planta.jpg">
                                </div>
                                <div class="question_tags">
                                    <p>
                                        <a href="#">tag1</a>
                                        <a href="#">tag2</a>
                                        <a href="#">tag4</a>
                                    </p>
                                </div>

                            </div>
                            <ul class="awenser_list">
                                <li>
                                    <div class="question_card">
                                        <div class="question_content">
                                            <div class="question_info">
                                                <img class="img_profile" src="../imagens/avatar.png" >
                                                <ul class="info_list">
                                                    <li class="name" >Pessoa</li>
                                                    <li class="label label-info" >Profissao</li>
                                                    <li class="email" >Email</li>
                                                </ul>
                                            </div>
                                            <div class="question_coment">
                                                <p>
                                                    Comment block
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="create_answer">
                                <div id="comment_form">
                                    <div class="resposta_title">
                                        <h2>Nova respostaa</h2>
                                    </div>
                                    <div class="resposta_info">
                                        <div>
                                            <input type="text" name="familia" id="familia=" placeholder="Familia">
                                        </div>
                                        <div>
                                            <input type="text" name="filo" id="filo" value="" placeholder="Filo">
                                        </div>
                                        <div>
                                            <input type="text" name="n_cientifio" id="n_cientifico" value="" placeholder="Nome Cientifico">
                                        </div>
                                    </div>

                                    <div class="resposta_text">
                                        <textarea rows="10" name="comment" id="comment" placeholder="Comment"></textarea>
                                    </div>
                                    <div >
                                        <Button class="resposta_submit"  type="submit" name="submit" value="Responder">Responder</Button>
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