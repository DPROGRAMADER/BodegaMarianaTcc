package com.example.Bodega.Controladores;

import com.example.Bodega.entidades.Zona;
import com.example.Bodega.servicios.zonaservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/zonas")
public class zonaControlador {
    @Autowired
    protected zonaservicio zonaServicio;
    @PostMapping
    public ResponseEntity<Zona> registar(@RequestBody Zona datosAGuardar){
        try {
        Zona zonaregistrada= zonaServicio.registrar(datosAGuardar);
        return ResponseEntity.status(HttpStatus.CREATED).body(zonaregistrada);
    }catch (Exception error){
        String mensaje="Ocurrio un error en el registro  "+error.getMessage();
        Zona zonaConerror=new Zona();
        zonaConerror.setCapacidad(mensaje);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(zonaConerror);
        }
    }
    @GetMapping
    public ResponseEntity<List<Zona>>buscarTodos(){

    try {
        List<Zona> zonas=zonaServicio.buscartodos();
        return ResponseEntity.status(HttpStatus.OK).body(zonas);
    }catch (Exception error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<Zona>buscarporId(@PathVariable Integer id){

        try {
            Zona zonaEncontrada=zonaServicio.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(zonaEncontrada);
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}



