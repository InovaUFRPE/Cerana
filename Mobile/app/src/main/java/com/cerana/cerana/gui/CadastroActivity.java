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

import com.cerana.cerana.Helper.Base64Custom;
import com.cerana.cerana.Helper.Preferencias;
import com.cerana.cerana.R;
import com.cerana.cerana.dao.ConfiguracaoFirebase;
import com.cerana.cerana.dominio.Pessoa;
import com.cerana.cerana.dominio.Usuario;
import com.cerana.cerana.negocio.CriptografiaSenha;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {
    private EditText et_email;
    private EditText et_password;
    private EditText et_password2;
    private EditText et_nome;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    private Resources resources;

    private CriptografiaSenha cripto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        et_email = (EditText) findViewById(R.id.et_register_login);
        et_password = (EditText) findViewById(R.id.et_register_password);
        et_password2 = (EditText) findViewById(R.id.et_register_password2);
        et_nome = (EditText) findViewById(R.id.et_register_nome);

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

        et_password.addTextChangedListener(textWatcher);
        et_email.addTextChangedListener(textWatcher);
        et_nome.addTextChangedListener(textWatcher);
        et_password2.addTextChangedListener(textWatcher);
    }

    public void cadastrar(View v) {
        if (et_password.getText().toString().equals(et_password2.getText().toString())) {
            usuario = new Usuario();
            usuario.setNome(et_nome.getText().toString());
            usuario.setEmail(et_email.getText().toString());
            usuario.setPassword(et_password.getText().toString());

            cadastrarUsuario();

        } else {
            Toast.makeText(CadastroActivity.this, "As senhas não são correspondentes.", Toast.LENGTH_LONG).show();
        }
    }

    private void cadastrarUsuario() {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getPassword()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(usuario.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuario.setId(identificadorUsuario);
                    usuario.salvar();

                    Preferencias preferencias = new Preferencias(CadastroActivity.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuario.getNome());

                    abrirLoginUsuario();
                } else {
                    String erroExcecao = "";

                    try {
                        throw task.getException();

                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroExcecao = "Digite uma senha mais forte, contendo no mínimo 6 caracteres de letras e números";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O e-mail digitado é inválido, digite um novo e-mail";
                    } catch (FirebaseAuthActionCodeException e) {
                        erroExcecao = "Esse e-mail já está cadastrado no sistema";
                    } catch (Exception e) {
                        erroExcecao = "Erro ao efetuar o cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, "Erro", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void abrirLoginUsuario() {
        Intent intent = new Intent(CadastroActivity.this, LogInActivity.class);
        startActivity(intent);
        finish();
    }
}



/*
    public void iniciarLoginActivity(){
        startActivity(new Intent(this, LogInActivity.class));
        finish();
    }

    private boolean validarCampos(){
        String nome = et_nome.getText().toString();
        String login = et_user.getText().toString();
        String senha = et_password.getText().toString();
        String senhaConfirma = et_password2.getText().toString();

        if(isCamposValidos(nome, login, senha, senhaConfirma) && isSenhasValidas(senha, senhaConfirma) &&
                validarLoginESenha(login,senha)){
            return  true;
        }
        return false;
    }

    public boolean isSenhasValidas(String campo_senha, String campo_senha_repetida) {
        if (campo_senha.equals(campo_senha_repetida)) {
            return true;
        }else{
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.erro_senha_comparar));
            return false;
        }
    }

    public boolean isCamposValidos(String nome, String login, String senha, String senhaConfirma) {
        boolean verificador = false;
        if (TextUtils.isEmpty(nome)) {
            et_nome.requestFocus();
            et_nome.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(login)) {
            et_user.requestFocus(); // troca ordem
            et_user.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.error_campo_vazio));
        } else if (TextUtils.isEmpty(senhaConfirma)) {
            et_password2.requestFocus();
            et_password2.setError(resources.getString(R.string.error_campo_vazio));
        }
        else {
            verificador = true;
        }
        return verificador;
    }
    public boolean validarLoginESenha(String login,String senha){
        boolean verificador = false;
        if(!usuarioNegocio.verEspacosBrancos(login)){
            et_user.requestFocus();
            et_user.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!usuarioNegocio.verAlfanumerico(login)){
            et_user.requestFocus();
            et_user.setError(resources.getString(R.string.erro_caracter_especial));
        }else if(!usuarioNegocio.verificarTamanho(login)){
            et_user.requestFocus();
            et_user.setError(resources.getString(R.string.erro_tamanho_login));
        }else if(!usuarioNegocio.verEspacosBrancos(senha)){
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.erro_espaco_branco));
        }else if(!usuarioNegocio.verAlfanumerico(senha)) {
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.erro_caracter_especial));
        }else if(!usuarioNegocio.verificarTamanho(senha)){
            et_password.requestFocus();
            et_password.setError(resources.getString(R.string.erro_tamanho_senha));
        }else {
            verificador = true;
        }
        return  verificador;
    }
}
*/
