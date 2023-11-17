package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class CadastrarMeta extends AppCompatActivity {

    private EditText editTextMetaGanharPesoAtual;
    private EditText editTextMetaGanharPesoDesejado;
    private EditText editTextMetaGanharQuantoTempo;
    private EditText editTextMetaPerderPesoAtual;
    private EditText editTextMetaPerderPesoDesejado;
    private EditText editTextMetaPerderQuantoTempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_meta);

        editTextMetaGanharPesoAtual = findViewById(R.id.editTextMetaGanharPesoAtual);
        editTextMetaGanharPesoDesejado = findViewById(R.id.editTextMetaGanharPesoDesejado);
        editTextMetaGanharQuantoTempo = findViewById(R.id.editTextMetaGanharQuantoTempo);
        editTextMetaPerderPesoAtual = findViewById(R.id.editTextMetaPerderPesoAtual);
        editTextMetaPerderPesoDesejado = findViewById(R.id.editTextMetaPerderPesoDesejado);
        editTextMetaPerderQuantoTempo = findViewById(R.id.editTextMetaPerderQuantoTempo);
    }

    public void register(View view)  {
        String GpesoAtual =  editTextMetaGanharPesoAtual.getText().toString();
        String GpesoDesejado =  editTextMetaGanharPesoDesejado.getText().toString();
        String GquantoTempo = editTextMetaGanharQuantoTempo.getText().toString();
    }
}
