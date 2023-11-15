package com.arqui.arquiorienobj;

import java.util.ArrayList;
import java.util.List;

// Clase Producto representa los productos en la tienda
class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    public Producto(int id, String nombre, double precio, int cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Métodos para obtener información del producto
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    // Otros métodos relacionados con la gestión del producto
    public void restarCantidad(int cantidad) {
        cantidadDisponible -= cantidad;
    }

    public void aumentarCantidad(int cantidad) {
        cantidadDisponible += cantidad;
    }
}

