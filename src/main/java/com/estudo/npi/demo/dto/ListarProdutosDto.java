package com.estudo.npi.demo.dto;

import java.util.Set;

public record ListarProdutosDto(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Set<CategoriaDto> categorias
) {
    public record CategoriaDto(
            Long id,
            String nomeCategoria
    ) {}
}
