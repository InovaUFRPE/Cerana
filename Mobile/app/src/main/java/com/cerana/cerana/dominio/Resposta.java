package com.cerana.cerana.dominio;


public class Resposta {
    private String texto;
    private int id;
    private Usuario usuario;
    private int idTopico;
    private String dataHora;

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public int getIdTopico(){
        return idTopico;
    }

    public void setIdTopico(int idTopico){
        this.idTopico = idTopico;
    }

    public String getDataHora() {

        return dataHora;
    }

    public void setDataHora(String dataHora) {

        this.dataHora = dataHora;
    }

}

