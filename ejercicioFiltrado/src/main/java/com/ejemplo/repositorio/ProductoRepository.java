package com.ejemplo.repositorio;
import com.ejemplo.modelo.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //filtro por nombre
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
