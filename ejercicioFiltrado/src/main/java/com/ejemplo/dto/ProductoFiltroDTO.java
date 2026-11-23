package com.ejemplo.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductoFiltroDTO(
        String nombre,
        BigDecimal precioMin,
        BigDecimal precioMax,
        List<String> marcas
) {
}
