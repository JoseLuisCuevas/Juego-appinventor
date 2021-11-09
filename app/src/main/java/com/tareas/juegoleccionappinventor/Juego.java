package com.tareas.juegoleccionappinventor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class Juego extends AppCompatActivity {
    //Declarando variables
    AppCompatImageView sprite;
    TextView Puntaje;
    int contador = 0;
    int alto, ancho;
    Random randNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_juego);
        //metodo que obtiene las medidas de la pantalla
        obtenerMedidas();

        //Incilizacion de variables
        Puntaje = (TextView) findViewById(R.id.Contador);
        sprite = (AppCompatImageView) findViewById(R.id.sprite);
        randNum = new Random();

        sprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador += 1;
                Puntaje.setText(String.valueOf(contador));
                moverSprite();
            }
        });
    }

    private void obtenerMedidas(){
        Display pantalla = getWindowManager().getDefaultDisplay();
        Point medidas = new Point();
        pantalla.getSize(medidas);
        ancho = medidas.x;
        alto = medidas.y;
    }

    private void moverSprite(){
        int min = 0;
        int Xmax = ancho - sprite.getWidth();
        int Ymax = alto - sprite.getHeight();
        int RandX = randNum.nextInt(((Xmax - min) + 1) + min);
        int RandY = randNum.nextInt(((Ymax - min) + 1) + min);
        sprite.setX(RandX);
        sprite.setY(RandY);
    }
}