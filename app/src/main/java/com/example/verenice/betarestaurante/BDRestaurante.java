package com.example.verenice.betarestaurante;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Verenice on 21/07/2015.
 */
public class BDRestaurante extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Restaurante.db";
    private static final String TABLA_PORCIONES = "porciones";
    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_PRECIO = "precio";
    public static final String  COLUMN_EXISTENCIAS ="existencias";

    public BDRestaurante(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_PORCIONES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_PRECIO + " REAL, " +
                COLUMN_EXISTENCIAS + " INTEGER " +

                ");";

        db.execSQL(query);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PORCIONES);
        onCreate(db);
    }

    //Añade un nuevo Row a la Base de Datos
    public void addPorciones(Porciones porciones) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, porciones.get_nombre());
        values.put(COLUMN_PRECIO, porciones.get_precio());
        values.put(COLUMN_EXISTENCIAS, porciones.get_existencias());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PORCIONES, null, values);
        db.close();

    }

    public void updateporciones(Porciones porciones){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, porciones.get_nombre());
        values.put(COLUMN_PRECIO, porciones.get_precio());
        values.put(COLUMN_EXISTENCIAS, porciones.get_existencias());

        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_PORCIONES, values, COLUMN_ID + "= ?", new String[] { String.valueOf(porciones.get_id())});
        db.close();

    }

    // Borrar una persona de la Base de Datos
    public void borrarPorciones(int porcion_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_PORCIONES + " WHERE " + COLUMN_ID + " = " + porcion_id + ";");
        db.close();
    }

    //listar por id

    public Cursor porcionesbyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_PORCIONES + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }


    //listar a todas las porciones
    public Cursor listarpersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_PORCIONES + " WHERE 1 ORDER BY " + COLUMN_NOMBRE + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

}
