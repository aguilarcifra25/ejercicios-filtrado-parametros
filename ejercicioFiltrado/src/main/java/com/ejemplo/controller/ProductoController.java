package com.ejemplo.controller;

import com.ejemplo.dto.ProductoFiltroDTO;
import com.ejemplo.modelo.Producto;
import com.ejemplo.repositorio.ProductoRepository;
import com.ejemplo.service.ProductoService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
@RestController
@RequestMapping
public class ProductoController {
    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
    private final ProductoRepository repository;
    private final ProductoService productoService;

    public ProductoController(ProductoRepository repository, ProductoService productoService) {
        this.repository = repository;
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> buscar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false)BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) List<String> marcas
            ){
        var filtro = new ProductoFiltroDTO(nombre, precioMin, precioMax, marcas);
        //var spec = ProductoSpecs.desde(filtro);
        return repository.findAll();
    }
}
