package com.ejemplo.repositorio;
import com.ejemplo.modelo.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    //filtro por nombre
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
