package com.ejemplo.repositorio;
import com.ejemplo.modelo.*;
import org.springframework.data.jpa.repository.*;

public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

}
