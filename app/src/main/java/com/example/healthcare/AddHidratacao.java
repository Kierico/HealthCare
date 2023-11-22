package com.example.healthcare;

import static com.example.healthcare.AddMetas.HID_CONSUMIDO;
import static com.example.healthcare.AddMetas.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddHidratacao extends AppCompatActivity {

    EditText hidratacaoEditText;
    Button hidratacaoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hidratacao);

        hidratacaoEditText = findViewById(R.id.editTextDigiteAquiAddHidratacao);
        hidratacaoButton = findViewById(R.id.buttonAddHidratacao);

        hidratacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdicionarHidratacao();
            }
        });
    }

    private void AdicionarHidratacao() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String hidConsumidos_valor = sharedPreferences.getString(HID_CONSUMIDO, "");

        String hidrata_registro = String.valueOf(Integer.parseInt(hidratacaoEditText.getText().toString()) + Integer.parseInt(hidConsumidos_valor));

        editor.putString(HID_CONSUMIDO, hidrata_registro);
        editor.apply();

        // Retorna para a tela principal
        startActivity(new Intent(AddHidratacao.this, metas.class));

    }
}