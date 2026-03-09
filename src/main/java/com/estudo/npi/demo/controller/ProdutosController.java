package com.estudo.npi.demo.controller;

import com.estudo.npi.demo.data.dto.ProdutosCriarDto;
import com.estudo.npi.demo.entity.Produto;
import com.estudo.npi.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody ProdutosCriarDto produtosCriarDto) {
        Produto produto = new Produto();
        produto.setNome(produtosCriarDto.getNome());
        produto.setDescricao(produtosCriarDto.getDescricao());
        produto.setPreco(produtosCriarDto.getPreco());
        produto.setCategoria(produtosCriarDto.getCategoria());

        Produto produtoSalvo = produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
