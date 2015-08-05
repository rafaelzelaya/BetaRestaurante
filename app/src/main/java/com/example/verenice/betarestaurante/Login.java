package com.example.verenice.betarestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Principal;

/**
 * Created by Verenice on 21/07/2015.
 */
public class Login extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button boton =(Button) findViewById(R.id.btnIniciar);
        Button btnventa = (Button) findViewById(R.id.btnVenta);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = ((EditText)findViewById(R.id.txtUsuario)).getText().toString();
                String contraseña=((EditText)findViewById(R.id.txtContraseña)).getText().toString();

                if(usuario.equals("admin")&& contraseña.equals("admin"))
                {

                    Intent callform = new Intent(Login.this,MainActivity.class);
                    startActivity(callform);
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(), "usuario y contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClickCambiar(View view){

        Intent callform = new Intent(this,MainActivity.class);
        startActivity(callform);
    }




}

