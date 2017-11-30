package com.cerana.cerana.negocio;

import android.content.Context;
import android.widget.Toast;


import com.cerana.cerana.dao.UsuarioDao;
import com.cerana.cerana.dominio.Pessoa;
import com.cerana.cerana.dominio.Topico;
import com.cerana.cerana.dominio.Usuario;
import com.cerana.cerana.dao.TopicoDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioNegocio {
    private Context context;
    private UsuarioDao usuarioDao;
    private TopicoDao topicoDao;
    private Pattern p1 = Pattern.compile("\\S+");
    private Pattern p2 = Pattern.compile("^[A-Za-z0-9]+$");
    private Matcher m;

    public UsuarioNegocio(Context context) {
        this.context=context;
    }

    public Usuario login(String email, String senha){
        usuarioDao = new UsuarioDao(context);
        Usuario usuario = usuarioDao.buscarUsuario(email, senha);
        return usuario;
    }

    public boolean validarCadastro(Pessoa pessoa)  {
        usuarioDao = new UsuarioDao(context);

        if (usuarioDao.buscarUsuario(pessoa.getUsuario().getLogin())==null){
            usuarioDao.inserirRegistro(pessoa);
            Toast.makeText(context, "Cadastro realizado", Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(context,"Usuário já cadastrado",Toast.LENGTH_LONG).show();
            return false;
        }

    }

    public boolean verEspacosBrancos(String campo){
        String texto = campo;
        m = p1.matcher(texto);
        return m.matches();
    }

    public boolean verAlfanumerico(String campo){
        String texto = campo;
        m = p2.matcher(texto);
        return m.matches();
    }

    public boolean verificarTamanhoSenha(String campo) {
        String texto = campo;
        if (texto.length()  < 8 ) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarTamanhoLogin(String campo){
        String texto = campo;
        if  (texto.length() < 5){
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarTamanhoNome(String campo){
        String texto = campo;
        if (verEspacosBrancos(campo));

        if  (texto.length() < 1 || texto.length() > 50){
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarTamanhoBio(String campo){
        String texto = campo;
        if  (texto.length() > 120){
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarTamanhoLoc(String campo){
        String texto = campo;
        if  (texto.length() < 4 || texto.length() > 20){
            return false;
        } else {
            return true;
        }
    }

    public void inserirTopico(Topico topico){
        topicoDao = new TopicoDao(context);
        topicoDao.inserirTopico(topico);
        Toast.makeText(context, "Publicação inserida", Toast.LENGTH_LONG).show();
    }
}
