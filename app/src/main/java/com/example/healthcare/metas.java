package com.example.healthcare;

import static com.example.healthcare.AddMetas.ALTURA;
import static com.example.healthcare.AddMetas.CAL_CONSUMIDO;
import static com.example.healthcare.AddMetas.HID_CONSUMIDO;
import static com.example.healthcare.AddMetas.IDADE;
import static com.example.healthcare.AddMetas.PESO_ATUAL;
import static com.example.healthcare.AddMetas.PESO_DESEJADO;
import static com.example.healthcare.AddMetas.SEXO;
import static com.example.healthcare.AddMetas.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class metas extends AppCompatActivity {
    //Ocultar barra de Navegação
    View decorView;
    Button addButton;
    TextView pesoDesejado_textView;
    TextView pesoAtual_textView;
    TextView imc_textView;

    //Calorias
    TextView calConsumir;
    TextView calConsumidos;

    //Hidratacao
    TextView hidConsumir;
    TextView hidConsumidos;

    // Dados
    private String pesoAtual;
    private String pesoDesejado;
    private String altura;
    private String idade;
    private String sexo;
    private String calConsumidos_valor;
    private String hidConsumidos_valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
        //Ocultar barra de Navegação
        decorView = getWindow().getDecorView();

        // Configurando views
        pesoDesejado_textView = findViewById(R.id.textViewMetaContadorPesoIdeal);
        pesoAtual_textView = findViewById(R.id.textViewMetaContadorPesoAtual);
        imc_textView = findViewById(R.id.textViewMetaContadorAlcanceMeta);
        calConsumir = findViewById(R.id.textViewCaloriasContadorConsumir);
        calConsumidos = findViewById(R.id.textViewCaloriasContadorConsumidos);
        hidConsumir = findViewById(R.id.textViewHidratacaoContadorConsumir);
        hidConsumidos = findViewById(R.id.textViewHidratacaoContadorConsumidos);

        addButton = findViewById(R.id.buttonAddMeta);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        loadData();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadData();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        pesoAtual = sharedPreferences.getString(PESO_ATUAL, "0");
        pesoDesejado = sharedPreferences.getString(PESO_DESEJADO, "0");
        altura = sharedPreferences.getString(ALTURA, "0");
        idade = sharedPreferences.getString(IDADE, "0");
        sexo = sharedPreferences.getString(SEXO, "");
        calConsumidos_valor = sharedPreferences.getString(CAL_CONSUMIDO, "0");
        hidConsumidos_valor = sharedPreferences.getString(HID_CONSUMIDO, "0");

        float pesoAtual_float = Float.parseFloat(pesoAtual);
        float altura_float = Float.parseFloat(altura);
        float idade_int = Float.parseFloat(idade);
        float calConsumir_valor = 0;

        if(Objects.equals(sexo, "Masculino")){
            calConsumir_valor = (float) ((13.75 * pesoAtual_float) + (5 * (altura_float * 100)) - (6.76 * idade_int) + 66.5);
        }else if (Objects.equals(sexo, "Feminino")){
            calConsumir_valor = (float) ((9.56 * pesoAtual_float) + (1.85 * (altura_float * 100)) - (4.68 * idade_int) + 665);
        }
        calConsumir.setText(String.format("%.0f", calConsumir_valor) + " cal");
        calConsumidos.setText(calConsumidos_valor + " cal");

        hidConsumir.setText(String.format("%.0f", 35 * pesoAtual_float) + " ml");
        hidConsumidos.setText(hidConsumidos_valor + " ml");

        pesoDesejado_textView.setText(pesoDesejado + " kg");
        pesoAtual_textView.setText(pesoAtual + " kg");

        float pesoIdeal = 22 * (altura_float * altura_float);

        imc_textView.setText(String.format("%.2f", pesoIdeal) + " kg");
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
                startActivity(new Intent(metas.this, AddCalorias.class));
            }
        });

        hidrataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fazer redirecionamento para página depois
                startActivity(new Intent(metas.this, AddHidratacao.class));
            }
        });

        metasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fazer redirecionamento para página depois
                startActivity(new Intent(metas.this, AddMetas.class));
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