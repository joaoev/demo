package com.estudo.npi.demo.services;

import com.estudo.npi.demo.dto.CriarCategoriaDto;
import com.estudo.npi.demo.dto.ListarCategoriasDto;

import java.util.List;

public interface CategoriaService {
    ListarCategoriasDto criarCategoria(CriarCategoriaDto criarCategoriaDto);
    List<ListarCategoriasDto> listarTodasCategorias();
}
