package com.cerana.cerana.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.text.Editable;

import com.cerana.cerana.R;
import com.cerana.cerana.dao.UsuarioDao;
import com.cerana.cerana.dominio.Pessoa;
import com.cerana.cerana.negocio.SessaoUsuario;
import com.cerana.cerana.negocio.UsuarioNegocio;

public class EditarPerfilActivity extends AppCompatActivity {

    private EditText etEditarNome;
    private EditText etEditarBio;
    private EditText etEditarLocalizacao;
    private SessaoUsuario sessaoUsuario;
    private UsuarioDao usuarioDao;
    private Resources resources;
    private UsuarioNegocio usuarioNegocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        etEditarNome = (EditText) findViewById(R.id.et_editarNome);
        etEditarBio = (EditText) findViewById(R.id.et_editarBio);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        usuarioDao = new UsuarioDao(getApplicationContext());

        sessaoUsuario.iniciarSessao(getApplicationContext());

        initViews();

    }

    public void initViews() {
        resources = (Resources) getResources();
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
        etEditarNome.addTextChangedListener(textWatcher);
        etEditarBio.addTextChangedListener(textWatcher);
    }

    public void editar(View v) throws Exception {
        usuarioDao = new UsuarioDao(getApplicationContext());
        usuarioNegocio = new UsuarioNegocio(getApplicationContext());
        Pessoa pessoa = sessaoUsuario.getUsuarioLogado();

        if (!isCamposValidos(etEditarNome.getText().toString())) {
            if (!usuarioNegocio.verificarTamanhoNome(etEditarNome.getText().toString())) {
                etEditarNome.requestFocus();
                etEditarNome.setError("Quantidade de caracteres não permitido.");
            } else {
                pessoa.setNome(etEditarNome.getText().toString());
            }
        }
        if (!isBioValida(etEditarBio.getText().toString())) {
            pessoa.setDescricao(etEditarBio.getText().toString());
            usuarioDao.atualizarRegistro(pessoa);
            startActivity(new Intent(this, PerfilActivity.class));
            finish();
        }
    }

    public boolean isCamposValidos(String nome) {
        boolean verificador = true;
        if (TextUtils.isEmpty(nome) || nome.trim().isEmpty()) {
            etEditarNome.requestFocus();
            etEditarNome.setError(resources.getString(R.string.error_campo_vazio));
        } else {
            verificador = false;
        }
        return verificador;
    }

    public boolean isBioValida(String bio) {
        usuarioNegocio = new UsuarioNegocio(getApplicationContext());
        boolean verficador = true;
        if (usuarioNegocio.verificarTamanhoBio(bio) == verficador) {
            etEditarBio.requestFocus();
            etEditarBio.setError("Limite máximo de caracteres ultrapassado.");
        } else {
            verficador = false;
        }
        return verficador;
    }
}