
package com.praticacarlos.service;

import org.springframework.stereotype.Service;

import com.praticacarlos.model.Producto;
import com.praticacarlos.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Obtener todos los productos
    public List<Producto> findAll() {
        return repository.findAll();
    }

    // Guardar un nuevo producto
    public Producto create(Producto producto) {
        return repository.save(producto);
    }
}

