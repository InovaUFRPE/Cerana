package com.cerana.cerana.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cerana.cerana.dominio.Resposta;

public class RespostaDao {
    private SQLiteDatabase db;
    private DbHelper dataBaseHelper;
    private Context context;

    public RespostaDao(Context context){
        this.context = context;
        dataBaseHelper = new DbHelper(context);
    }

    public long inserirResposta(Resposta resposta){
        db = dataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        String colunaIdUser = DbHelper.RESPOSTA_ID_USER;
        int idUser = resposta.getUsuario().getId();
        values.put(colunaIdUser, idUser);

        String colunaTexto = DbHelper.TEXTO_RESPOSTA;
        String texto = resposta.getTexto();
        values.put(colunaTexto, texto);

        String colunaData = DbHelper.DATA_RESPOSTA;
        String data = resposta.getDataHora();
        values.put(colunaData, data);

        String tabela = DbHelper.TABELA_RESPOSTA;

        long id = db.insert(tabela, null, values);

        return id;

    }





}
