package com.example.challenge.Animales;

import java.io.Serializable;

public class Animales  implements Serializable {
    private String nombre, imagen, descripcion;
    public Animales(){

    }
    public Animales(String nombre, String imagen, String descripcion){
        this.nombre=nombre;
        this.imagen=imagen;
        this.descripcion=descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
