package com.estudo.npi.demo.mappers;

import com.estudo.npi.demo.dto.CriarCategoriaDto;
import com.estudo.npi.demo.model.Categorias;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriasMapper {
    Categorias toEntity(CriarCategoriaDto dto);

    CriarCategoriaDto toDto(Categorias categoria);

    List<CriarCategoriaDto> toDtoList(List<Categorias> categorias);
}
