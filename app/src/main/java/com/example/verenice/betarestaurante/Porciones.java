package com.example.verenice.betarestaurante;

/**
 * Created by Verenice on 21/07/2015.
 */
public class Porciones {

    private int _id;
    private String _nombre;
    private double _precio;
    private int _existencias;

    public Porciones(){
        //constructor vacio
    }

    public Porciones(String nombre, double precio, int existencias) {
        this._nombre = nombre;
        this._precio = precio;
        this._existencias = existencias;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public double get_precio() {
        return _precio;
    }

    public void set_precio(float _precio) {
        this._precio = _precio;
    }

    public int get_existencias() {
        return _existencias;
    }

    public void set_existencias(int _existencias) {
        this._existencias = _existencias;
    }

}
