package com.example.Bodega.servicios;

import com.example.Bodega.entidades.zona;
import com.example.Bodega.repositorios.Zonarepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZonaServicio implements ServicioBase<zona>{
    @Autowired
    private Zonarepositorio zonarepositorio;

    @Override
    public List<zona> buscartodos() throws Exception {
        return null;
    }

    @Override
    public zona buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public zona registrar(zona datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public zona actualizar(Integer id, zona datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
