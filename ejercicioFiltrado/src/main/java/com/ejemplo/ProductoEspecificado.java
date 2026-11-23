package com.ejemplo;

import com.ejemplo.modelo.Producto;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.math.BigDecimal;
import java.util.List;

public class ProductoEspecificado {

    public static PredicateSpecification<Producto> filtrarPorNombre(String nombre) {

        return (from, cb) ->
                cb.like(cb.lower(from.get("nombre")), "%" + nombre.toLowerCase() + "%");

    }

    public static PredicateSpecification<Producto> filtrarPorPrecio(BigDecimal precioMin, BigDecimal precioMax) {

        return (from, cb) -> {

            var precio = from.<BigDecimal>get("precio");

            if (precioMin != null && precioMax != null) {

                return cb.between(precio, precioMin, precioMax);

            }

            if (precioMin != null) {

                return cb.greaterThanOrEqualTo(precio, precioMin);

            }

            if (precioMax != null) {

                return cb.lessThanOrEqualTo(precio, precioMax);

            }

            return cb.conjunction();
        };
    }

    public static PredicateSpecification<Producto> filtrarPorMarcas(List<String> marcas) {

        return (from, cb) -> {

            if (marcas == null || marcas.isEmpty()) {

                return cb.conjunction();

            }

            return from.get("marca").in(marcas);
        };
    }

}
