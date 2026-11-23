package com.ejemplo.service;

import com.ejemplo.ProductoEspecificado;
import com.ejemplo.dto.ProductoFiltroDTO;
import com.ejemplo.modelo.Producto;
import com.ejemplo.repositorio.ProductoRepository;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> buscarPorPrecio(ProductoFiltroDTO filtro) {
        PredicateSpecification<Producto> spec =
                ProductoEspecificado.filtrarPorNombre(filtro.nombre())
                        .and(ProductoEspecificado.filtrarPorPrecio(filtro.precioMin(), filtro.precioMax()));

        return productoRepository.findAll(spec);
    }

    public List<Producto> buscarPorMarca(ProductoFiltroDTO filtro) {
        PredicateSpecification<Producto> spec =
                ProductoEspecificado.filtrarPorNombre(filtro.nombre())
                        .and(ProductoEspecificado.filtrarPorPrecio(filtro.precioMin(), filtro.precioMax()))
                        .and(ProductoEspecificado.filtrarPorMarcas(filtro.marcas()));

        return productoRepository.findAll(spec);
    }

    public List<Producto> buscarPorNombre(ProductoFiltroDTO filtro) {
        if (filtro.nombre() == null || filtro.nombre().isBlank()) {
            return productoRepository.findAll();
        }
        return productoRepository.findAll(ProductoEspecificado.filtrarPorNombre(filtro.nombre()));
    }
}
