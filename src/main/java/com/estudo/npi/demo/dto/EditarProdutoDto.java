package com.estudo.npi.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;

import java.util.Set;

public record EditarProdutoDto (
        @NotBlank(message = "nome e obrigatorio")
        @Size(max = 255, message = "nome deve ter no maximo 255 caracteres")
        String nome,

        @NotBlank(message = "descricao e obrigatoria")
        String descricao,

        @NotNull(message = "preco e obrigatorio")
        @PositiveOrZero(message = "preco deve ser maior ou igual a zero")
        Double preco,

        @JsonAlias("categoriasId")
        @Positive
        Set<Long> categoriasIds
) {

}