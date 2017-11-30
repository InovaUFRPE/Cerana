package com.cerana.cerana.dao;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import com.cerana.cerana.dominio.Topico;


public class TopicoDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private Context context;

    public TopicoDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
    }

    public long inserirTopico(Topico topico){
        db = dataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        String colunaIdUser = DbHelper.TOPICO_ID_USER;
        int idUser = topico.getIdUsuario();
        values.put(colunaIdUser, idUser);

        String colunaTitulo = DbHelper.TITULO_TOPICO;
        String titulo = topico.getTitulo();
        values.put(colunaTitulo, titulo);

        String colunaTexto = DbHelper.TEXTO_TOPICO;
        String texto = topico.getTexto();
        values.put(colunaTexto, texto);

        String colunaData = DbHelper.DATA_TOPICO;
        String dataHora = topico.getDataHora();
        values.put(colunaData, dataHora);

        String tabela = DbHelper.TABELA_TOPICO;

        long id = db.insert(tabela, null, values);

        db.close();

        return id;
    }

}
