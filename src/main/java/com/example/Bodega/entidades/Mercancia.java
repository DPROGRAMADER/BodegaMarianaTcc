package com.example.Bodega.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcionProducto")
    private String descripcionProducto;

    @Column(name = "FechaIngreso")
    private LocalDateTime fechaIngreso;

    public Mercancia( ) {
    }

    public Mercancia(Integer id, String nombreProducto, String ubicacion, String descripcionProducto, LocalDateTime fechaIngreso) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.ubicacion = ubicacion;
        this.descripcionProducto = descripcionProducto;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId( ) {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto( ) {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getUbicacion( ) {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcionProducto( ) {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public LocalDateTime getFechaIngreso( ) {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
