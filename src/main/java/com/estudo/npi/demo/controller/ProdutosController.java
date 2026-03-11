package com.estudo.npi.demo.controller;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.EditarProdutoDto;
import com.estudo.npi.demo.dto.ListarProdutosDto;
import com.estudo.npi.demo.services.ProdutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<CriarProdutoDto> criarProduto(@Valid @RequestBody CriarProdutoDto criarProdutoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosService.criarProduto(criarProdutoDto));
    }

    @GetMapping
    public ResponseEntity<List<ListarProdutosDto>> listarTodosProdutos() {
        return ResponseEntity.ok(produtosService.listarTodosProdutos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListarProdutosDto> editarProduto(@PathVariable Long id, @Valid @RequestBody EditarProdutoDto editarProdutoDto) {
        return ResponseEntity.ok(produtosService.editarProduto(id, editarProdutoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtosService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
