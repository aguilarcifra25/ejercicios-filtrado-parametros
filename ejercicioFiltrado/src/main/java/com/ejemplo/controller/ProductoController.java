package com.ejemplo.controller;

import com.ejemplo.modelo.Producto;
import com.ejemplo.service.ProductoService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
@RestController
@RequestMapping
public class ProductoController {
    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/v1")
    public List<Producto> filtrar(@RequestParam Map<String, String> filtros) {
        log.info("Filtros recibidos: {}", filtros);
        return productoService.filtrar(filtros);
    }
}
