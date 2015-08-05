package com.example.verenice.betarestaurante;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Verenice on 21/07/2015.
 */
public class AgregarPorcion extends ActionBarActivity {

    BDRestaurante dbRestaurante;
    EditText nombre_input;
    EditText precio_input;
    EditText existencias_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        nombre_input = (EditText) findViewById(R.id.nombre_input);
        precio_input = (EditText) findViewById(R.id.precio_input);
        existencias_input = (EditText) findViewById(R.id.existencias_input);


        dbRestaurante = new BDRestaurante(this, null, null, 1);
    }
    //Añade una Persona a la Base de Datos

    public void agregar_clicked(View view){

        Porciones porciones = new Porciones( nombre_input.getText().toString(), Double.parseDouble(precio_input.getText().toString()), Integer.parseInt(existencias_input.getText().toString() )) ;
       dbRestaurante.addPorciones(porciones);
        confirmacion();
        limpiarcampos();
    }


    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre_input.setText("");
        precio_input.setText("");
        existencias_input.setText("");



    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha agregado exitosamente!");
        dlgAlert.setTitle("Agregar Porcion");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }




}
