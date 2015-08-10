package com.example.verenice.betarestaurante;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.TextView;


public class Prueba extends ActionBarActivity {

    //actualizado 1.0
    //clase de prueba en donde seran recibidos los datos del anterior activity orden

    TextView tv_gracias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        tv_gracias = (TextView) findViewById(R.id.tv_gracias);

        Bundle extras = getIntent().getExtras();

        Double xCarne    = extras.getDouble("Carne");
        Double xPollo    = extras.getDouble("Pollo");
        Double xPescado  = extras.getDouble("Pescado");
        Double xArroz    = extras.getDouble("Arroz");
        Double xEnsalada = extras.getDouble("Ensalada");
        Double xBebida   = extras.getDouble("Bebida");


        tv_gracias.setText("Total Porciones seleccionadas: \n "
                + xCarne   + "\n + "
                + xPollo   + "\n + "
                + xPescado + "\n + "
                + xArroz   + "\n + "
                + xEnsalada+ "\n + "
                + xBebida  + "\n  ");

        //problema de no poder recivir los datos de anterior activity : Orden

    }


}
