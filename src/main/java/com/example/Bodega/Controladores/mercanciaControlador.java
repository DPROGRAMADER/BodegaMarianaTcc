package com.example.Bodega.Controladores;

import com.example.Bodega.entidades.Mercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/mercancias")
public class mercanciaControlador {
    @Autowired
    protected com.example.Bodega.servicios.mercanciaServicio mercanciaServicio;
    @PostMapping
    public ResponseEntity<Mercancia> registar(@RequestBody Mercancia datosAGuardar){
    try {
        Mercancia mercanciaregistrada=mercanciaServicio.registrar(datosAGuardar);
        return ResponseEntity.status(HttpStatus.CREATED).body(mercanciaregistrada);
    }catch (Exception error){
        String mensaje="Tenemos un error en el registro  "+error.getMessage();
        Mercancia mercanciaConerror =new Mercancia();
        mercanciaConerror.setNombreProducto(mensaje);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mercanciaConerror);
        }
    }
    @GetMapping
    public ResponseEntity<List<Mercancia>>buscartodos(){

    try {
        List<Mercancia> mercancias=mercanciaServicio.buscartodos();
        return ResponseEntity.status(HttpStatus.OK).body(mercancias);
    }catch (Exception error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Mercancia>buscarporId(@PathVariable Integer id){

    try {
        Mercancia mercanciaEncontrada=mercanciaServicio.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(mercanciaEncontrada);
    }catch (Exception error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
