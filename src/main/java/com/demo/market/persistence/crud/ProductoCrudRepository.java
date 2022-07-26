package com.demo.market.persistence.crud;

import com.demo.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    @Query(value="SELECT + FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    List<Producto> findByCantidadStockLessThanAndEstado(int idCategoria, boolean estado);
}
