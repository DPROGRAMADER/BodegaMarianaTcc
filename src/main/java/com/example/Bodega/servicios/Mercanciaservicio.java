package com.example.Bodega.servicios;

import com.example.Bodega.entidades.Mercancia;
import com.example.Bodega.repositorios.Mercanciarepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Mercanciaservicio implements ServicioBase<Mercancia> {
    @Autowired
    private Mercanciarepositorio mercanciarepositorio;
    @Override
    public List<Mercancia> buscartodos() throws Exception {
        return null;
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
