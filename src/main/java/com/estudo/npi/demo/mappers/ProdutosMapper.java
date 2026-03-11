package com.estudo.npi.demo.mappers;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.ListarProdutosDto;
import com.estudo.npi.demo.model.Categorias;
import com.estudo.npi.demo.model.Produtos;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProdutosMapper {

    @Mapping(target = "categorias", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "disponivel", constant = "true")
    Produtos toEntity(CriarProdutoDto dto);

    @Mapping(source = "categorias", target = "categoriasIds", qualifiedByName = "categoriasParaIds")
    @Mapping(target = "preco", source = "preco")
    CriarProdutoDto toDTO(Produtos produto);

    @Named("categoriasParaIds")
    default Set<Long> categoriasParaIds(Set<Categorias> categorias) {
        if (categorias == null || categorias.isEmpty()) {
            return new HashSet<>();
        }
        return categorias.stream().map(Categorias::getId).collect(Collectors.toSet());
    }

    ListarProdutosDto toListarDto(Produtos produto);
    List<ListarProdutosDto> toListarDtoList(List<Produtos> produtos);
}