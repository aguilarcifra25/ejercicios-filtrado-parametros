package com.ejemplo.controlador;

import com.ejemplo.modelo.Producto;
import com.ejemplo.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Producto>> filtrar(@RequestParam String nombre) {

        if (nombre == null || nombre.isBlank()) {
            log.info("Sin filtro por nombre");
        } else {
            log.info("Filtro por nombre: {}", nombre);
        }

        return ResponseEntity.ok(productoService.buscarPorNombre(nombre));

    }
}

