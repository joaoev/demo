package com.estudo.npi.demo.dto;

import com.estudo.npi.demo.model.Categorias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record CriarProdutoDto (
    @NotBlank(message = "nome e obrigatorio")
    @Size(max = 255, message = "nome deve ter no maximo 255 caracteres")
    String nome,

    @NotBlank(message = "descricao e obrigatoria")
    String descricao,

    @NotNull(message = "preco e obrigatorio")
    @PositiveOrZero(message = "preco deve ser maior ou igual a zero")
    Double preco,

    Set<Categorias> categoriasIds
) {

}