package com.example.Bodega.repositorios;

import com.example.Bodega.entidades.zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Zonarepositorio extends JpaRepository<zona,Integer> {
}
