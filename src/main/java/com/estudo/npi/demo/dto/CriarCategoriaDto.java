package com.estudo.npi.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CriarCategoriaDto(
    @NotBlank(message = "nome e obrigatorio")
    @Size(max = 255, message = "nome deve ter no maximo 255 caracteres")
    String nomeCategoria
) {
}
