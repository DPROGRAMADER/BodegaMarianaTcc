package com.example.Bodega.servicios;

import com.example.Bodega.entidades.Zona;
import com.example.Bodega.repositorios.Zonarepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZonaServicio implements ServicioBase<Zona>{
    @Autowired
    private Zonarepositorio zonarepositorio;

    @Override
    public List<Zona> buscartodos() throws Exception {
        return null;
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Zona registrar(Zona datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Zona actualizar(Integer id, Zona datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
