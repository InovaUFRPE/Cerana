package com.cerana.cerana.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.cerana.cerana.R;
import com.cerana.cerana.dominio.Topico;
import com.cerana.cerana.negocio.SessaoUsuario;
import com.cerana.cerana.negocio.UsuarioNegocio;

public class CriarPublicacaoActivity extends AppCompatActivity {
    private EditText et_titulo;
    private EditText et_texto;

    private Resources resources;
    private UsuarioNegocio usuarioNegocio;
    private SessaoUsuario sessaoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_publicacao);

        usuarioNegocio = new UsuarioNegocio(getApplicationContext());

        et_titulo = (EditText) findViewById(R.id.edtPergunta);
        et_texto = (EditText) findViewById(R.id.edtDescricao);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        sessaoUsuario.iniciarSessao(getApplicationContext());


        initViews();
    }

    public void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        et_titulo.addTextChangedListener(textWatcher);
        et_texto.addTextChangedListener(textWatcher);

    }

    public boolean isCamposValidos(String titulo){
        boolean verificador = false;
        if (TextUtils.isEmpty(titulo) || titulo.trim().isEmpty()) {
            et_titulo.requestFocus();
            et_titulo.setError(resources.getString(R.string.error_campo_vazio));
        }
        else {
            verificador = true;
        }
        return verificador;
    }

    public boolean validarCampos(){
        String titulo = et_titulo.getText().toString();

        if (isCamposValidos(titulo)){
            return true;
        }
        return false;
    }

    public void voltarHomeLoginActivity(){
        startActivity(new Intent(this, TelaInicialActivity.class));
        finish();
    }


    public void inserirPublicacao(View v) throws Exception{
        boolean validar = validarCampos();
        if (validar){
            sessaoUsuario = new SessaoUsuario(getApplicationContext());
            Topico topico = new Topico();

            topico.setTexto(et_texto.getText().toString());
            topico.setTitulo(et_titulo.getText().toString());
            topico.setIdUsuario(sessaoUsuario.getUsuarioLogado().getId());

            usuarioNegocio.inserirTopico(topico);
            voltarHomeLoginActivity();
        }

    }





}
