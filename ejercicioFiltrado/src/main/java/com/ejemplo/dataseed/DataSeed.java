package com.ejemplo.dataseed;

import com.ejemplo.modelo.Producto;
import com.ejemplo.repositorio.ProductoRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;

public class DataSeed {

    private final ProductoRepository repo;

    public DataSeed(ProductoRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void crearProductos () {

        repo.saveAll(List.of(
                new Producto("Sobre de papel", 25.00),
                new Producto("Sobre acolchado", 32.50),
                new Producto("Cuaderno A5", 48.90),
                new Producto("Mochila escolar", 89.99),
                new Producto("Auriculares inalámbricos", 215.00),
                new Producto("Teclado mecánico", 239.95),
                new Producto("Monitor 24 pulgadas", 329.00),
                new Producto("Silla ergonómica", 549.00),
                new Producto("Portátil 15 pulgadas", 899.00),
                new Producto("Smartphone gama alta", 1257.00)
        ));

    }


}
