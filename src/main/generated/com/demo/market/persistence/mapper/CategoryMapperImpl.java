package com.demo.market.persistence.mapper;

import com.demo.market.domain.Category;
import com.demo.market.persistence.entity.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T14:43:55-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Private Build)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoria.getIdCategoria() != null ) {
            category.setCategoryId( categoria.getIdCategoria() );
        }
        category.setCategory( categoria.getDescripcion() );
        if ( categoria.getEstado() != null ) {
            category.setActive( Boolean.parseBoolean( categoria.getEstado() ) );
        }

        return category;
    }

    @Override
    public Categoria toCategoria(Category category) {
        if ( category == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( (long) category.getCategoryId() );
        categoria.setDescripcion( category.getCategory() );
        categoria.setEstado( String.valueOf( category.isActive() ) );

        return categoria;
    }
}
