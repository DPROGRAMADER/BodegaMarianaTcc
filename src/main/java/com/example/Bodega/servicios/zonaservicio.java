package com.example.Bodega.servicios;

import com.example.Bodega.entidades.Mercancia;
import com.example.Bodega.entidades.zona;
import com.example.Bodega.repositorios.Zonarepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ZonaServicio implements ServicioBase<zona>{
    @Autowired
    private Zonarepositorio zonarepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<zona> buscartodos() throws Exception {
        try {
            List<zona> zonas=zonarepositorio.findAll();
            return zonas;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public zona buscarPorId(Integer id) throws Exception {
        try {
            Optional<zona>zonaOptional=zonarepositorio.findById(id);
            if (zonaOptional.isPresent()){
                return zonaOptional.get();
            }else {
                throw new Exception("La zona no esta registrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public zona registrar(zona datosARegistrar) throws Exception {
        try {
            zona zonaRegistrada=zonarepositorio.save(datosARegistrar);
            return zonaRegistrada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public zona actualizar(Integer id, zona datosNuevos) throws Exception {
        try {
            Optional<zona>zonaOptional=zonarepositorio.findById(id);
            zona zonaExcistente=zonaOptional.get();
            zonaExcistente.setCapacidad(datosNuevos.getCapacidad());
            zona zonaActualizada=zonarepositorio.save(zonaExcistente);
            return zonaActualizada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<zona>zonaOptional=zonarepositorio.findById(id);
            if (zonaOptional.isPresent()){
                zonarepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("zona no registrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

