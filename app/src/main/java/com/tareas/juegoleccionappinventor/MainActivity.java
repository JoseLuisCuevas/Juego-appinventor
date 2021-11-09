package com.tareas.juegoleccionappinventor;

//librerias
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    AppCompatButton botonJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Inicializacion de variables
        botonJugar = (AppCompatButton) findViewById(R.id.PlayButton);
        botonJugar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent juegoView = new Intent(getApplicationContext(), Juego.class);
                startActivity(juegoView);
            }
        });
    }
}