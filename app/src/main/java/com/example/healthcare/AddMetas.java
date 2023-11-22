package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddMetas extends AppCompatActivity {

    View decorView;
    Button salvarButton;
    RadioGroup radioGroup;

    // Dados (variáveis)
    EditText pesoAtual;
    EditText altura;
    EditText idade;
    EditText pesoDesejado;

    // Dados armazenados
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PESO_ATUAL = "pesoAtual";
    public static final String PESO_DESEJADO = "pesoDesejado";
    public static final String ALTURA = "altura";
    public static final String IDADE = "idade";
    public static final String SEXO = "sexo";
    public static final String CAL_CONSUMIDO = "calConsumido";
    public static final String HID_CONSUMIDO = "hidConsumido";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_metas);
        decorView = getWindow().getDecorView();
        salvarButton = findViewById(R.id.buttonAvancarAddMetas);
        radioGroup = findViewById(R.id.objetivo);

        // Dados
        pesoAtual = findViewById(R.id.editTextPesoAtualGanharPesoAddMetas);
        idade = findViewById(R.id.editTextQuantoTempoGanharPesoAddMetas);
        pesoDesejado = findViewById(R.id.editTextPesoDesejadoGanharPesoAddMetas);
        altura = findViewById(R.id.editTextMetaGanharAltura);

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(pesoAtual.getText().toString()) || "".equals(pesoDesejado.getText().toString()) || "".equals(altura.getText().toString()) || "".equals(idade.getText().toString())) {
                    Toast.makeText(AddMetas.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    salvarMeta();
                }
            }
        });
    }

    private void salvarMeta() {

        // Capturando o tipo de objetivo
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.objetivo);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
        String tipoObjetivo = (String) radioButton.getText();

        // Capturando o tipo de objetivo
        RadioGroup sexoGroup = (RadioGroup) findViewById(R.id.sexo);
        int sexoID = sexoGroup.getCheckedRadioButtonId();
        RadioButton sexoButton = (RadioButton) sexoGroup.findViewById(sexoID);
        String sexo = (String) sexoButton.getText();

        // Salvando informações
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PESO_ATUAL, pesoAtual.getText().toString());
        editor.putString(PESO_DESEJADO, pesoDesejado.getText().toString());
        editor.putString(ALTURA, altura.getText().toString());
        editor.putString(IDADE, idade.getText().toString());
        editor.putString(SEXO, sexo.toString());
        editor.putString(CAL_CONSUMIDO, "0");
        editor.putString(HID_CONSUMIDO, "0");

        editor.apply();

        // Retorna para a tela principal
        startActivity(new Intent(AddMetas.this, metas.class));

    }

    //Ocultar barra de Navegação
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}