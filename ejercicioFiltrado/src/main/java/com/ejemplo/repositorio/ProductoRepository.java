package com.ejemplo.repositorio;
import com.ejemplo.modelo.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //EndPoint v1

}
