package com.estudo.npi.demo.mappers;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.model.Categorias;
import com.estudo.npi.demo.model.Produtos;
import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProdutosMapper {

    @Mapping(source = "categoriasIds", target = "categorias", qualifiedByName = "copyCategorias")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "disponivel", constant = "true")
    Produtos toEntity(CriarProdutoDto dto);

    @Mapping(source = "categorias", target = "categoriasIds", qualifiedByName = "copyCategorias")
    @Mapping(target = "preco", source = "preco")
    CriarProdutoDto toDTO(Produtos produto);

    @Named("copyCategorias")
    default Set<Categorias> copyCategorias(Set<Categorias> categorias) {
        return categorias == null ? new HashSet<>() : new HashSet<>(categorias);
    }
}