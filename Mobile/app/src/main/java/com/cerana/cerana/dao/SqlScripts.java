package com.cerana.cerana.dao;

import static com.cerana.cerana.dao.DbHelper.DATA_RESPOSTA;
import static com.cerana.cerana.dao.DbHelper.DATA_TOPICO;
import static com.cerana.cerana.dao.DbHelper.DESCRICAO;
import static com.cerana.cerana.dao.DbHelper.ID_PESSOA;
import static com.cerana.cerana.dao.DbHelper.ID_RESPOSTA;
import static com.cerana.cerana.dao.DbHelper.ID_TOPICO;
import static com.cerana.cerana.dao.DbHelper.ID_USER;
import static com.cerana.cerana.dao.DbHelper.LOCATION;
import static com.cerana.cerana.dao.DbHelper.NOME;
import static com.cerana.cerana.dao.DbHelper.PASSWORD;
import static com.cerana.cerana.dao.DbHelper.PESSOA_USER;
import static com.cerana.cerana.dao.DbHelper.RESPOSTA_ID_USER;
import static com.cerana.cerana.dao.DbHelper.TABELA_PESSOA;
import static com.cerana.cerana.dao.DbHelper.TABELA_RESPOSTA;
import static com.cerana.cerana.dao.DbHelper.TABELA_TOPICO;
import static com.cerana.cerana.dao.DbHelper.TABELA_USUARIO;
import static com.cerana.cerana.dao.DbHelper.TEXTO_RESPOSTA;
import static com.cerana.cerana.dao.DbHelper.TEXTO_TOPICO;
import static com.cerana.cerana.dao.DbHelper.TITULO_TOPICO;
import static com.cerana.cerana.dao.DbHelper.TOPICO_ID_USER;
import static com.cerana.cerana.dao.DbHelper.USER;

public class SqlScripts {
    protected String createTabelaUsuario(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+ TABELA_USUARIO +" ( ");
        userBuilder.append(ID_USER +" integer primary key autoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected String createTabelaPessoa() {

        StringBuilder pessoaBuilder = new StringBuilder();
        pessoaBuilder.append("CREATE TABLE " + TABELA_PESSOA + " ( ");
        pessoaBuilder.append(ID_PESSOA + " integer primary key autoincrement, ");
        pessoaBuilder.append(NOME + " text not null, ");
        pessoaBuilder.append(LOCATION+" text, ");
        pessoaBuilder.append(DESCRICAO+" text, ");
        pessoaBuilder.append(PESSOA_USER + " text not null unique);");
        return pessoaBuilder.toString();
    }

    protected String createTabelaTopico(){
        StringBuilder topicoBuilder = new StringBuilder();
        topicoBuilder.append("CREATE TABLE " + TABELA_TOPICO + " ( ");
        topicoBuilder.append(ID_TOPICO + " integer primary key autoincrement, ");
        topicoBuilder.append(TITULO_TOPICO + " text not null, ");
        topicoBuilder.append(TEXTO_TOPICO + " text not null, ");
        topicoBuilder.append(DATA_TOPICO + " text not null, ");
        topicoBuilder.append(TOPICO_ID_USER + " integer);");
        return topicoBuilder.toString();
    }

    protected String createTabelaResposta(){
        StringBuilder respostaBuilder = new StringBuilder();
        respostaBuilder.append("CREATE TABLE "+ TABELA_RESPOSTA + " ( ");
        respostaBuilder.append(ID_RESPOSTA + " integer primary key autoincrement, ");
        respostaBuilder.append(TEXTO_RESPOSTA + " text not null, ");
        respostaBuilder.append(DATA_RESPOSTA + " text not null, ");
        respostaBuilder.append(RESPOSTA_ID_USER + " integer);");
        return respostaBuilder.toString();
    }


    protected String cmdWhere(String tabela, String a, String b){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ? AND " + b + " LIKE ?";
    }
    protected String cmdWhere(String tabela, String a){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ?";
    }
    protected String cmdWhereValues(String tabela, String coluna, String valor){
        return "SELECT * FROM" + tabela +" WHERE " + coluna + " LIKE " + valor;
    }
}