package com.estudo.npi.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EditarCategoriaDto(
        @NotBlank(message = "nome e obrigatorio")
        @Size(min = 3, max = 255, message = "nome deve ter no maximo 255 caracteres")
        String nomeCategoria
) {
}
