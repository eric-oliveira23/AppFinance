package com.eric.organizzeclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.eric.organizzeclone.R;
import com.eric.organizzeclone.helper.DateUtil;
import com.eric.organizzeclone.model.Movimentacao;
import com.google.firebase.database.DatabaseReference;

public class DespesasActivity extends AppCompatActivity {

    private Movimentacao movimentacao;
    private EditText edtData, edtCategoria, edtValor, edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        edtCategoria = findViewById(R.id.edtCategoria);
        edtData = findViewById(R.id.edtData);
        edtValor = findViewById(R.id.edtValor);
        edtDescricao = findViewById(R.id.edtDescricao);

        edtData.setText(DateUtil.retornarData());

    }

    public void salvarDespesa(View view){

    String data = edtData.getText().toString();

    movimentacao = new Movimentacao();
    movimentacao.setValor(Double.parseDouble(edtValor.getText().toString()));
    movimentacao.setCategoria(edtCategoria.getText().toString());
    movimentacao.setDescricao(edtDescricao.getText().toString());
    movimentacao.setData(data);
    movimentacao.setTipo("d");

    movimentacao.salvar(data);

    }

}