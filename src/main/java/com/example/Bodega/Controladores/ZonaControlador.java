package com.example.Bodega.Controladores;

import com.example.Bodega.entidades.Mercancia;
import com.example.Bodega.entidades.zona;
import com.example.Bodega.servicios.ZonaServicio;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/zonas")
public class ZonaControlador {
    @Autowired
    protected ZonaServicio  zonaServicio;

    @PostMapping
    public ResponseEntity<zona> registar(@RequestBody zona datosAGuardar) {

        try {
            Mercancia zonaRegistrada = zonaServicio.registrar(datosAGuardar);
            return ResponseEntity.status(HttpStatus.CREATED).body(zonaRegistrada);
        } catch (Exception error) {
            String mensaje = "Ocurrio un error en el registro " + error.getMessage();
            zona zonaConError = new zona();
            zonaConError.setMensajeError(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(zonaConError);

        }
    }
    @GetMapping
    public ResponseEntity<List<zona>>buscarTodos(){
        try{

            List<zona> zona=zonaServicio.buscartodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zona);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<zona>buscarPorId(@PathVariable Integer id){
        try{
            Mercancia zonaEncontrada=zonaServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaEncontrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }
}
}
