package com.ejemplo.service;

import com.ejemplo.modelo.Producto;
import com.ejemplo.repositorio.ProductoRepository;
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

    public List<Producto> filtrar(Map<String, String> filtros) {
        String nombre = filtros.get("nombre");
        List<Producto> resultado = new ArrayList<>();

        for (Producto p : productoRepository.findAll()) {
            if (cumpleNombre(p, nombre) && cumpleRangos(p, filtros)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Si no hay nombre, vale todo
    private boolean cumpleNombre(Producto p, String nombre) {
        if (nombre == null) {
            return true;
        }
        return p.getNombre().toLowerCase().contains(nombre.toLowerCase());
    }

    // Si no hay rangos, vale todo
    // Si hay rangos, basta con cumplir uno
    private boolean cumpleRangos(Producto p, Map<String, String> filtros) {
        if (!filtros.containsKey("min1")) {
            return true;
        }

        int i = 1;
        while (filtros.containsKey("min" + i)) {
            double min = Double.parseDouble(filtros.get("min" + i));
            double max = Double.parseDouble(filtros.get("max" + i));
            double precio = p.getPrecio().doubleValue();
            if (precio >= min && precio <= max) {
                return true;
            }
            i++;
        }
        return false;
    }
        public List<Producto> buscarPorNombre(String nombre) {

        return productoRepository.findByNombreContainingIgnoreCase(nombre);

    }
}
