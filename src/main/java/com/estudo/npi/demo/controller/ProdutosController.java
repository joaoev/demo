package com.estudo.npi.demo.controller;

import com.estudo.npi.demo.data.dto.ProdutosCriarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Controller
@ResponseBody
@RequestMapping("/produtos")
public class ProdutosController {
    // @GetMapping
    // public ResponseEntity<List<ProdutosCriarDto>> listarProdutos() {
    // return ResponseEntity.ok(Collections.singletonList(new ProdutosCriarDto()));
    // }

    @PostMapping
    public ResponseEntity<ProdutosCriarDto> criarProduto(@Valid @RequestBody ProdutosCriarDto produtosCriarDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosCriarDto);
    }

}
