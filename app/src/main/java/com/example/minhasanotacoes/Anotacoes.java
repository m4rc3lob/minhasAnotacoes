package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacoes {

    private Context context;
    private SharedPreferences sharedPreferences;
    private final String NOME_ARQUIVO = "anotacoes";

    private SharedPreferences.Editor editor;
    private final String NOME_CHAVE = "nome";

    public Anotacoes(Context c) {
        this.context = c;
        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = sharedPreferences.edit();
    }

    public void salvaAlteracao(String anotacao){
        editor.putString(NOME_CHAVE, anotacao);
        editor.commit();
    }

    public String recuperaAnotacao (){
        return sharedPreferences.getString(NOME_CHAVE, "");
    }
}
