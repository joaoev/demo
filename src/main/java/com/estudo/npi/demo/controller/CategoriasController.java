package com.estudo.npi.demo.controller;


import com.estudo.npi.demo.dto.CriarCategoriaDto;
import com.estudo.npi.demo.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CriarCategoriaDto> criarCategoria(@Valid @RequestBody CriarCategoriaDto criarCategoriaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criarCategoria(criarCategoriaDto));
    }

    @GetMapping
    public ResponseEntity<List<CriarCategoriaDto>> listarTodasCategorias() {
        return ResponseEntity.ok(categoriaService.listarTodasCategorias());
    }
}
