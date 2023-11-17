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
    //Ocultar barra de Navegação
    View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar barra de Navegação
        decorView = getWindow().getDecorView();

        usuario = findViewById(R.id.editTextUser);
        senha = findViewById(R.id.editTextPassword);
        entrar = findViewById(R.id.buttonEntrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(usuario.getText().toString()) && "".equals(senha.getText().toString())) {

                    Toast falhaAutenticacao = Toast.makeText(MainActivity.this, "Por favor, insira um usuário válido ou cadastre-se!", Toast.LENGTH_SHORT);
                    falhaAutenticacao.show();

                } else if ("Jose".equals(usuario.getText().toString()) && "123".equals(senha.getText().toString())) {

                    /** intent Intent, bundle options */
                    startActivity(new Intent(MainActivity.this, metas.class));

                } else {
                    Toast falhaAutenticacao = Toast.makeText(MainActivity.this, getResources().getString(R.string.activity_main_falha_autenticacao), Toast.LENGTH_SHORT);
                    falhaAutenticacao.show();
                }
            }
        });
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