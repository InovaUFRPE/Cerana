package com.cerana.cerana.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.text.Editable;

import com.cerana.cerana.R;
import com.cerana.cerana.dao.UsuarioDao;
import com.cerana.cerana.dominio.Pessoa;
import com.cerana.cerana.negocio.SessaoUsuario;

public class EditarPerfilActivity extends AppCompatActivity {

    private EditText etEditarNome;
    private EditText etEditarBio;
    private EditText etEditarLocalizacao;
    private SessaoUsuario sessaoUsuario;
    private UsuarioDao usuarioDao;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        etEditarNome = (EditText)findViewById(R.id.et_editarNome);
        etEditarBio = (EditText)findViewById(R.id.et_editarBio);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        usuarioDao = new UsuarioDao(getApplicationContext());

        sessaoUsuario.iniciarSessao(getApplicationContext());

        initViews();

    }

    public void initViews(){
        resources = (Resources) getResources();
        TextWatcher textWatcher = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
            }


            @Override
            public  void afterTextChanged(Editable s){

            }

        };
        etEditarNome.addTextChangedListener(textWatcher);
        etEditarBio.addTextChangedListener(textWatcher);
    }

    public void editar(View v) throws Exception{
        usuarioDao = new UsuarioDao(getApplicationContext());
        Pessoa pessoa = sessaoUsuario.getUsuarioLogado();
        pessoa.setNome(etEditarNome.getText().toString());
        pessoa.setDescricao(etEditarBio.getText().toString());
        usuarioDao.atualizarRegistro(pessoa);
        startActivity(new Intent(this, PerfilActivity.class));
        finish();
    }
}

