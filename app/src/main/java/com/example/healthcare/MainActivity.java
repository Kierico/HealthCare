package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText senha;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextUser);
        senha = findViewById(R.id.editTextPassword);
        entrar = findViewById(R.id.buttonEntrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(usuario.getText().toString()) && "".equals(senha.getText().toString())) {

                    /** intent Intent, bundle options */
                    startActivity(new Intent(MainActivity.this, CadastrarMeta.class));

                } else {
                    Toast falhaAutenticacao = Toast.makeText(MainActivity.this, getResources().getString(R.string.activity_main_falha_autenticacao), Toast.LENGTH_SHORT);
                    falhaAutenticacao.show();
                }
            }
        });
    }
}