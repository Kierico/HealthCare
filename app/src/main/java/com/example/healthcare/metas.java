package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class metas extends AppCompatActivity {
    //Ocultar barra de Navegação
    View decorView;

    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
        //Ocultar barra de Navegação
        decorView = getWindow().getDecorView();
        addButton = findViewById(R.id.button12);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        // Atribuindo funções à cada botão
        ImageButton caloriasButton = dialog.findViewById(R.id.caloriasButton);
        ImageButton hidrataButton = dialog.findViewById(R.id.hidrataButton);
        ImageButton metasButton = dialog.findViewById(R.id.metasButton);

        caloriasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fazer redirecionamento para página depois
                Toast.makeText(metas.this, "Calorias", Toast.LENGTH_SHORT).show();
            }
        });

        hidrataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fazer redirecionamento para página depois
                Toast.makeText(metas.this, "Hidratação", Toast.LENGTH_SHORT).show();
            }
        });

        metasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fazer redirecionamento para página depois
                Toast.makeText(metas.this, "Metas", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

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