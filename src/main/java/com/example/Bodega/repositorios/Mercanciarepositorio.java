package com.example.Bodega.repositorios;

import com.example.Bodega.entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mercanciarepositorio extends JpaRepository<Mercancia,Integer>{
}
