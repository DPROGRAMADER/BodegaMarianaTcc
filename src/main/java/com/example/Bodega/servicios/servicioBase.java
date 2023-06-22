package com.example.Bodega.servicios;

import java.util.List;

public interface servicioBase<E>{

    public List<E> buscartodos() throws Exception;
    public E buscarPorId(Integer id) throws  Exception;
    public E  registrar(E datosARegistrar) throws Exception;
    public E actualizar(Integer id, E datosNuevos) throws Exception;
    public boolean eliminar(Integer id) throws Exception;
}
