package com.demo.market.persistence.mapper;

import com.demo.market.domain.PurchaseItem;
import com.demo.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source="comprasProductoPK.idProducto", target="productId"),
            @Mapping(source="cantidad", target="quantity"),
            @Mapping(source="estado", target="active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="comprasProductoPK.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
