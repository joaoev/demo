package com.estudo.npi.demo.services;

import com.estudo.npi.demo.dto.CriarCategoriaDto;

import java.util.List;

public interface CategoriaService {
    CriarCategoriaDto criarCategoria(CriarCategoriaDto criarCategoriaDto);
    List<CriarCategoriaDto> listarTodasCategorias();
}
