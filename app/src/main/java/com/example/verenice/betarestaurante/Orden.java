package com.example.verenice.betarestaurante;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Orden extends ActionBarActivity {

    //variables de contador,contadores
    private int contador1 = 0,
            contador2 = 0,
            contador3 = 0,
            contador4 = 0,
            contador5 = 0,
            contador6 = 0,

    contadorTotal = 0;

    //Operaciones
    private double suma;

    //textos
    private TextView ctnCarne,
            ctnPollo,
            ctnPescado,
            ctnArroz,
            ctnEnsalada,
            ctnBebida;

    //declaracion de botones
    private Button BotonCarne,
            BotonPollo,
            BotonPescado,
            BotonArroz,
            BotonEnsalada,
            BotonBebida,
            BtnEnviar;

    //precios de porciones
    private double precioCarne = 1.50,
            precioPollo = 1.40,
            precioPescado = 1.35,
            precioArroz = 0.50,
            precioEnsalada = 0.45,
            precioBebida = 0.65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        //botones
        BotonCarne = (Button) findViewById(R.id.BtnCarne);
        BotonPollo = (Button) findViewById(R.id.BtnPollo);
        BotonPescado = (Button) findViewById(R.id.BtnPescado);
        BotonArroz = (Button) findViewById(R.id.btnArroz);
        BotonEnsalada = (Button) findViewById(R.id.BtnEnsalada);
        BotonBebida = (Button) findViewById(R.id.BtnBebida);

        BtnEnviar = (Button) findViewById(R.id.BtnEnviarOrde);
/*editado por rafael como prueba para GITHUB*/

        //contadores
        ctnCarne = (TextView) findViewById(R.id.txtTotalCarne);
        ctnPollo = (TextView) findViewById(R.id.txtTotalPollo);
        ctnPescado = (TextView) findViewById(R.id.txtTotalPescado);
        ctnArroz = (TextView) findViewById(R.id.txtTotalArroz);
        ctnEnsalada = (TextView) findViewById(R.id.txtTotalEnsalada);
        ctnBebida = (TextView) findViewById(R.id.txtTotalBebida);

        //boton de carne con contador
        BotonCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador1++;
                contadorTotal++;
                ctnCarne.setText("Contador: " + contador1);
                suma = (contador1 * precioCarne);
                Toast.makeText(getApplicationContext(), "precio: " + suma + "  Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });


        //boton de pollo
        BotonPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador2++;
                contadorTotal++;
                ctnPollo.setText("Contador: " + contador2);
                suma = (contador2 * precioPollo);
                Toast.makeText(getApplicationContext(), " Precio: " + suma + " Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });

        //boton de pescado

        BotonPescado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador3++;
                contadorTotal++;
                ctnPescado.setText("Contador: " + contador3);
                suma = (contador3 * precioPescado);
                Toast.makeText(getApplicationContext(), " Precio: " + suma + " Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });

        //boton arroz

        BotonArroz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador4++;
                contadorTotal++;
                ctnArroz.setText("Contador: " + contador4);
                suma = (contador4 * precioArroz);
                Toast.makeText(getApplicationContext(), " Precio: " + suma + " Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });


        BotonEnsalada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador5++;
                contadorTotal++;
                ctnEnsalada.setText("Contador: " + contador5);
                suma = (contador5 * precioEnsalada);
                Toast.makeText(getApplicationContext(), "precio: " + suma + " Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });


        BotonBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador6++;
                contadorTotal++;
                ctnBebida.setText("Contador: " + contador6);
                suma = (contador6 * precioBebida);
                Toast.makeText(getApplicationContext(), "precio: " + suma + " Porciones: " + contadorTotal, Toast.LENGTH_LONG).show();
            }
        });
               /*
                 actualizacion 1.0
               este metodo comentariado o desabilitado para poder ejecutar onclick enviar orden
            BtnEnviar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    Toast.makeText(getApplicationContext(),"Orden Enviada",Toast.LENGTH_LONG).show();
                }
            });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_orden, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

       //actualizado 1.0
       // un evento onclick para mandar las ordenes al activity prueba

    public void onClickEnviarOrden(View view)
    {


        //int Xcontador1 = Integer.parseInt(contador1.getText().toString());


        if(contadorTotal>0)
           {
            Intent i = new Intent(this, Prueba.class);

            i.putExtra("Carne"   ,contador1);
            i.putExtra("Pollo"   ,contador2);
            i.putExtra("Pescado" ,contador3);
            i.putExtra("Arroz"   ,contador4);
            i.putExtra("Ensalada",contador5);
            i.putExtra("Bebida"  ,contador6);

            startActivity(i);
        }
        else{
            Toast.makeText(getApplicationContext(), "Debe selecionar porciones", Toast.LENGTH_SHORT).show();
        }

    }


}
