package com.praticacarlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praticacarlos.model.Producto;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

}