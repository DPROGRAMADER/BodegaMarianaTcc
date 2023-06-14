package com.example.Bodega.entidades;
import jakarta.persistence.*;

@Entity
@Table(name="zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capacidad")
    private String capacidad;

    @Column(name="tiempo")
    private String tiempo;

    public Zona( ) {
    }

    public Zona(Integer id, String nombre, String capacidad, String tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempo = tiempo;
    }

    public Integer getId( ) {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre( ) {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapacidad( ) {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getTiempo( ) {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
