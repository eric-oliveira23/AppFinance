package com.eric.organizzeclone.model;

import com.eric.organizzeclone.config.ConfigFirebase;
import com.eric.organizzeclone.helper.Base64Custom;
import com.eric.organizzeclone.helper.DateUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Movimentacao {

    private String data;
    private String categoria;
    private String descricao;
    private String tipo;
    private double valor;

    public Movimentacao() {
    }

    public void salvar(String data){

        FirebaseAuth auth = ConfigFirebase.getAutenticacao();

        String idUsuario = Base64Custom.codificarBase64(auth.getCurrentUser().getEmail());

        String mesAno = DateUtil.mesAnoData(data);

        DatabaseReference reference = ConfigFirebase.getDatabaseReference();
        reference.child("movimentacao")
                .child(idUsuario)
                .child(mesAno)
                .push()
                .setValue(this);

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
