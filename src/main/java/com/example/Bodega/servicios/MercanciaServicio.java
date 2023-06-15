package com.example.Bodega.servicios;

import com.example.Bodega.entidades.Mercancia;
import com.example.Bodega.repositorios.Mercanciarepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class MercanciaServicio implements ServicioBase<Mercancia> {
    @Autowired
    private Mercanciarepositorio mercanciarepositorio;
    @Override
    @Transactional(readOnly = true)
    public List<Mercancia> buscartodos() throws Exception {
        try {
            List<Mercancia> mercancias=mercanciarepositorio.findAll();
            return mercancias;
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional =mercanciarepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                return mercanciaOptional.get();
            } else {
                throw new Exception("La mercancia no registra");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        try {
            Mercancia mercanciaRegistrada=mercanciarepositorio.save(datosARegistrar);
            return mercanciaRegistrada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional=mercanciarepositorio.findById(id);
            Mercancia mercanciaExistente=mercanciaOptional.get();
            mercanciaExistente.setNombreProducto(datosNuevos.getNombreProducto());
            Mercancia mercanciaActualizada=mercanciarepositorio.save(mercanciaExistente);
            return mercanciaActualizada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Mercancia>mercanciaOptional=mercanciarepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                mercanciarepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Mercancia No encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
