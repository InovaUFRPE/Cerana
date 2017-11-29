package com.cerana.cerana.dominio;

public class Pessoa{
    private int id;
    private Usuario usuario;
    private String nome;
    private String localizazao;
    private String descricao;

    public Pessoa(){
        this.nome = null;
        this.usuario = null;
        this.descricao = null;
        this.localizazao = null;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {return descricao; }

    public String getLocalizazao() {return localizazao; }

    public void setDescricao(String descricao) {this.descricao = descricao; }

    public void setLocalizazao(String localizazao) {this.localizazao = localizazao; }

}

