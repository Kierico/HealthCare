package com.example.healthcare;

import static com.example.healthcare.AddMetas.CAL_CONSUMIDO;
import static com.example.healthcare.AddMetas.HID_CONSUMIDO;
import static com.example.healthcare.AddMetas.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCalorias extends AppCompatActivity {

    EditText caloriasEditText;
    Button caloriasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calorias);

        caloriasEditText = findViewById(R.id.editTextDigiteAquiAddCalorias);
        caloriasButton = findViewById(R.id.buttonAddCalorias);

        caloriasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdicionarCalorias();
            }
        });
    }

    private void AdicionarCalorias() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String calConsumidos_valor = sharedPreferences.getString(CAL_CONSUMIDO, "");

        String calorias_registro = String.valueOf(Integer.parseInt(caloriasEditText.getText().toString()) + Integer.parseInt(calConsumidos_valor));

        editor.putString(CAL_CONSUMIDO, calorias_registro);
        editor.apply();

        // Retorna para a tela principal
        startActivity(new Intent(AddCalorias.this, metas.class));
    }


}