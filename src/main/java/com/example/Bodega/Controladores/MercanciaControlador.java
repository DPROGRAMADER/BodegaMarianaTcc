package com.example.Bodega.Controladores;

import com.example.Bodega.servicios.Mercanciaservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Mercancia")
public class MercanciaControlador {
    @Autowired
    protected Mercanciaservicio mercanciaservicio;

    
}
