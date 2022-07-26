package com.demo.market.persistence;

import com.demo.market.domain.Product;
import com.demo.market.domain.repository.ProductRepository;
import com.demo.market.persistence.crud.ProductoCrudRepository;
import com.demo.market.persistence.entity.Producto;
import com.demo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
     @Autowired
    private ProductoCrudRepository productoCrudRepository;

     @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategoria){
        List<Producto> productos = productoCrudRepository.findByIdCategoria(idCategoria);
        return Optional.ofNullable(mapper.toProducts(productos));
    }

    @Override
    public List<Product> finByIdCategoriaOrderByNombreAsc(int IdCategoria){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(IdCategoria);
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int cantidad){
        Optional<List<Producto>> productos = Optional.ofNullable(productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true));
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        productoCrudRepository.save(producto);
        return mapper.toProduct(producto);
    }

    @Override
    public Optional<Product> getProduct(long productId){
        return productoCrudRepository.
                findById(productId).
                map(producto -> mapper.toProduct(producto));
    }

    @Override
    public void delete(long idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
