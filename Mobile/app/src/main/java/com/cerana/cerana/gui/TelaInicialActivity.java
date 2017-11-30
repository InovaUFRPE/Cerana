package com.cerana.cerana.gui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.cerana.cerana.R;
import com.cerana.cerana.negocio.SessaoUsuario;

public class TelaInicialActivity extends AppCompatActivity {

        private SharedPreferences preferences;
        private SessaoUsuario sessao;
        private TextView boasVindas;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_inicial);
            bemVindo();
        }
    @SuppressLint("WrongConstant")
    public void bemVindo(){
        preferences = getSharedPreferences("user", Context.MODE_APPEND);
        sessao = new SessaoUsuario(getApplicationContext());

        if (sessao.verificarLogin()){
            finish();
        }
        boasVindas = (TextView)findViewById(R.id.boasVindas);
        String bemvindo = boasVindas.getText().toString() +  sessao.getNome() + ".";
        boasVindas.setText(bemvindo);
    }

    public void startPerfilActivity(View view){
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }

    public void criarPublicacaoActivity(View view){
        startActivity(new Intent(this, CriarPublicacaoActivity.class));
    }




}
