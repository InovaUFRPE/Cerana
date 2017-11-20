package com.cerana.cerana.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    protected static final String NOME_DB = "banco.db";
    protected static final int VERSAO = 2;
    private SqlScripts scripts = new SqlScripts();

    // TABELA USUARIO
    protected static final String TABELA_USUARIO = "tabela_usuarios";
    protected static final String ID_USER = "_id_usuario";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";
    protected static final String LOCATION = "location";
    protected static final String DESCRICAO = "descricao";

    // TABELA PESSOA
    protected static final String TABELA_PESSOA = "tabela_pessoas";
    protected static final String ID_PESSOA = "_id_pessoa";
    protected static final String NOME = "nome";
    protected static final String PESSOA_USER = "pessoa_usuario";

    //TABELA TOPICO
    protected static final String TABELA_TOPICO = "tabela_topicos";
    protected static final String ID_TOPICO = "_id_topico";
    protected static final String TEXTO_TOPICO = "texto";
    protected static final String TITULO_TOPICO = "titulo";
    protected static final String DATA_TOPICO = "data_topico";
    protected static final String TOPICO_ID_USER = "_id_user";

    //TABELA RESPOSTA
    protected static final String TABELA_RESPOSTA = "tabela_respostas";
    protected static final String ID_RESPOSTA = "_id_resposta";
    protected static final String TEXTO_RESPOSTA = "texto";
    protected static final String DATA_RESPOSTA = "data_resposta";
    protected static final String RESPOSTA_ID_USER = "_id_user";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts.createTabelaUsuario());
        db.execSQL(scripts.createTabelaPessoa());
        db.execSQL(scripts.createTabelaTopico());
        db.execSQL(scripts.createTabelaResposta());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_TOPICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_RESPOSTA);
        onCreate(db);
    }
}
