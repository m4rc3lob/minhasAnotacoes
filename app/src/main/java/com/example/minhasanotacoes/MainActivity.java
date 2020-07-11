package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Anotacoes anotacoes;
    private EditText campoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anotacoes = new Anotacoes(getApplicationContext());
        campoTexto = findViewById(R.id.campoTexto);

        FloatingActionButton fab = findViewById(R.id.buttonSave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //salvando anotação
                String textoRecuperado = campoTexto.getText().toString();
                if ( textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha alguma anotação para salvar os dados.", Snackbar.LENGTH_LONG).show();
                }else {
                    anotacoes.salvaAlteracao(textoRecuperado);
                    Snackbar.make(view, "Dados salvos com sucesso!", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        //recuperando anotação
        String textoRecuperado = anotacoes.recuperaAnotacao();
        if(!textoRecuperado.equals("")){
            campoTexto.setText(textoRecuperado);
        }
    }


}