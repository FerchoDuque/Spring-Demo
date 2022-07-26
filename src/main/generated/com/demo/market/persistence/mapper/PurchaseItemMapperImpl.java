package com.demo.market.persistence.mapper;

import com.demo.market.domain.PurchaseItem;
import com.demo.market.persistence.entity.ComprasProducto;
import com.demo.market.persistence.entity.ComprasProductoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T14:44:00-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Private Build)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ComprasProducto producto) {
        if ( producto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Long idProducto = productoComprasProductoPKIdProducto( producto );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto.intValue() );
        }
        if ( producto.getCantidad() != null ) {
            purchaseItem.setQuantity( producto.getCantidad() );
        }
        if ( producto.getEstado() != null ) {
            purchaseItem.setActive( producto.getEstado() );
        }
        purchaseItem.setTotal( producto.getTotal() );

        return purchaseItem;
    }

    @Override
    public ComprasProducto toComprasProducto(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setComprasProductoPK( purchaseItemToComprasProductoPK( item ) );
        comprasProducto.setCantidad( item.getQuantity() );
        comprasProducto.setEstado( item.isActive() );
        comprasProducto.setTotal( item.getTotal() );

        return comprasProducto;
    }

    private Long productoComprasProductoPKIdProducto(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }
        ComprasProductoPK comprasProductoPK = comprasProducto.getComprasProductoPK();
        if ( comprasProductoPK == null ) {
            return null;
        }
        Long idProducto = comprasProductoPK.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected ComprasProductoPK purchaseItemToComprasProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProductoPK comprasProductoPK = new ComprasProductoPK();

        comprasProductoPK.setIdProducto( (long) purchaseItem.getProductId() );

        return comprasProductoPK;
    }
}
