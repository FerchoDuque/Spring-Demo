package com.demo.market.domain.repository;

import com.demo.market.domain.Product;
import com.demo.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    List<Product> finByIdCategoriaOrderByNombreAsc(int IdCategoria);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(long productId);
    Product saveProduct(Product product);
    void delete(long productId);
}
