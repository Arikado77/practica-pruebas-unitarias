
package com.praticacarlos.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.praticacarlos.model.Producto;
import com.praticacarlos.repository.ProductoRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    // PRUEBA 1: Obtener todos los productos
    @Test
    void testFindAll() {

        Producto producto1 = new Producto("Laptop", 15000.0);
        Producto producto2 = new Producto("Mouse", 350.0);

        List<Producto> productos =
                Arrays.asList(producto1, producto2);

        when(repository.findAll())
                .thenReturn(productos);

        List<Producto> resultado = service.findAll();

        assertThat(resultado).hasSize(2);
        assertThat(resultado)
                .extracting(Producto::getNombre)
                .containsExactly("Laptop", "Mouse");

        verify(repository, times(1)).findAll();
    }

    // PRUEBA 2: Crear un producto
    @Test
    void testCreate() {

        Producto producto = new Producto("Teclado", 800.0);

        when(repository.save(producto))
                .thenReturn(producto);

        Producto resultado = service.create(producto);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getNombre())
                .isEqualTo("Teclado");
        assertThat(resultado.getPrecio())
                .isEqualTo(800.0);

        verify(repository, times(1)).save(producto);
    }
}
