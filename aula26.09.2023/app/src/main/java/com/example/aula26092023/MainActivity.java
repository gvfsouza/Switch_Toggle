package com.example.aula26092023;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Switch switchButton;
    ToggleButton toggleButton;
    TextView switchResultado;
    TextView toggleResultado;
    Button enviarButton;
    String nomeSalvo;
    Integer idadeSalva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = findViewById(R.id.switchButton);
        toggleButton = findViewById(R.id.toggleButton);
        switchResultado = findViewById(R.id.switchResultado);
        toggleResultado = findViewById(R.id.toggleResultado);
        enviarButton = findViewById(R.id.enviarButton);
        nome = findViewById(R.id.editTextNome);
        idade = findViewById(R.id.editTextIdade);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (switchButton.isChecked()){
                    switchResultado.setText("Estoy Cansada com Fome");
                } else {
                    switchResultado.setText("FOMEEEEEE");
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (toggleButton.isChecked()){
                    toggleResultado.setText("Togle Ligado");
                } else {
                    toggleResultado.setText("Toggle Desligado");
                }
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nomeSalvo = nome.getText().toString();
                    idadeSalva = Integer.parseInt(idade.getText().toString());
                    valoresSalvos.setText("Nome: " + nomeSalvo + " idade: " + idadeSalva);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Entre com valores", Toast.LENGTH_SHORT).show();
                }

            }
        });

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nome",nomeSalvo)
                intent.putExtra("idade",idadeSalva)
                startActivity(intent);
            }
        });

    }
}