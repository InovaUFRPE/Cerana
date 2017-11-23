package com.cerana.cerana.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cerana.cerana.R;
import com.cerana.cerana.dao.ConfiguracaoFirebase;
import com.cerana.cerana.dominio.Usuario;
import com.cerana.cerana.negocio.CriptografiaSenha;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogInActivity extends AppCompatActivity {
    private EditText et_login;
    private EditText et_password;
    private FirebaseAuth autenticacao;
    private Usuario usuario;

    private Resources resources;

    private CriptografiaSenha cripto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login = (EditText) findViewById(R.id.user_login);
        et_password = (EditText) findViewById(R.id.user_password);

        initViews();
    }

    @Override
    public void onResume(){
        super.onResume();
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

        et_password.addTextChangedListener(textWatcher);
        et_login.addTextChangedListener(textWatcher);
    }

    public void startCadastroActivity(View v){
        Intent i = new Intent(LogInActivity.this, CadastroActivity.class);
        startActivity(i);
    }

    public void startMainActivity(){
        Intent i = new Intent(LogInActivity.this, TelaInicialActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
    /*
    public void logar(View v) throws Exception {
        boolean validar=validarCampos();
        if(validar){

            usuarioNegocio = new UsuarioNegocio(getApplicationContext());

            String usuario = et_login.getText().toString();
            String senha = et_password.getText().toString();

            cripto = new CriptografiaSenha();
            String novaSenha = cripto.criptoSenha(senha);

            sessao = new SessaoUsuario(getApplicationContext());

            Usuario validado = usuarioNegocio.login(usuario, novaSenha);

            if (validado ==  null){
                et_login.requestFocus();
                et_login.setError(resources.getString(R.string.erro_valido_usuario_senha));
            }else {
                sessao.logarUsuario(usuario);
                startMainActivity();
            }
        }
    }
    */
    private boolean validarCampos(){

        String login = et_login.getText().toString();
        String senha = et_password.getText().toString();

        if(isCamposValidos(login, senha)){
            return  true;
        }
        return false;
    }

    public boolean isCamposValidos(String login, String senha) {
        boolean verificador = false;
        if (TextUtils.isEmpty(login)) {
            et_login.requestFocus();
            et_login.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
        } else {
            verificador = true;
        }
        return verificador;
    }
    private void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(),usuario.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    startMainActivity();
                    Toast.makeText(LogInActivity.this, "Login efetuado com sucesso.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LogInActivity.this, "Usuário ou senha inválidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void logar(View v){
        if (!et_login.getText().toString().equals("") && !et_password.getText().toString().equals("")) {
            usuario = new Usuario();
            usuario.setEmail(et_login.getText().toString());
            usuario.setPassword(et_password.getText().toString());
            validarLogin();
        } else {
            Toast.makeText(LogInActivity.this, "Preencha os campos de e-mail e senha!", Toast.LENGTH_LONG).show();
        }
    }
}


