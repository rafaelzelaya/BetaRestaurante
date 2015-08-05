package com.example.verenice.betarestaurante;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by Verenice on 21/07/2015.
 */
public class BuscarPorcion   extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_porcion);

        BDRestaurante bdrestaurante;
        bdrestaurante = new  BDRestaurante (this, null, null, 1);
        SQLiteDatabase db = bdrestaurante.getWritableDatabase();
        Cursor cursor = bdrestaurante.listarpersonas();

        ListView lvlitems = (ListView) findViewById(R.id.lvlitems);
        lvlitems.setTextFilterEnabled(true);
        final TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, cursor);
        lvlitems.setAdapter(todoAdapter);

    }


}
