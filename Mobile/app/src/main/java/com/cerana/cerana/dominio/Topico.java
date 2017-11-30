package com.cerana.cerana.dominio;

public class Topico {
    private String titulo;
    private String texto;
    private int id;
    private int idUsuario;
    private String dataHora;

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

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

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public String getDataHora() {

        return dataHora;
    }

    public void setDataHora(String dataHora) {

        this.dataHora = dataHora;
    }
}
