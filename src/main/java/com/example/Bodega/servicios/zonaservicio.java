package com.example.Bodega.servicios;

import com.example.Bodega.entidades.Zona;
import com.example.Bodega.repositorios.Zonarepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class zonaservicio implements servicioBase<Zona> {
    @Autowired
    private Zonarepositorio zonarepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Zona> buscartodos() throws Exception {
        try {
            List<Zona> Zonas =zonarepositorio.findAll();
            return Zonas;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try {
            Optional<Zona>zonaOptional=zonarepositorio.findById(id);
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
    public Zona registrar(Zona datosARegistrar) throws Exception {
        try {
            Zona zonaRegistrada=zonarepositorio.save(datosARegistrar);
            return zonaRegistrada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona datosNuevos) throws Exception {
        try {
            Optional<Zona>zonaOptional=zonarepositorio.findById(id);
            Zona zonaExcistente=zonaOptional.get();
            zonaExcistente.setCapacidad(datosNuevos.getCapacidad());
            Zona zonaActualizada=zonarepositorio.save(zonaExcistente);
            return zonaActualizada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Zona>zonaOptional=zonarepositorio.findById(id);
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

