package com.demo.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;

    private String nombre;

    @Column(name="id_categoria")
    private Integer idCategoria;

    @Column(name="codigo_barras")
    private String codigBarras;

    @Column(name="precio_venta")
    private Double precioVentas;

    @Column(name="cantidad_stock")
    private Integer cantidadStock;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    private Boolean estado;

    public Producto() {
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return Math.toIntExact(idProducto);
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = Long.valueOf(idProducto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigBarras() {
        return codigBarras;
    }

    public void setCodigBarras(String codigBarras) {
        this.codigBarras = codigBarras;
    }

    public Double getPrecioVentas() {
        return precioVentas;
    }

    public void setPrecioVentas(Double precioVentas) {
        this.precioVentas = precioVentas;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
