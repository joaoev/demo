package com.estudo.npi.demo.services;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.ListarProdutosDto;

import java.util.List;

public interface ProdutosService {
    CriarProdutoDto criarProduto(CriarProdutoDto produto);
//    Produtos listarProdutoPorId(Long id);
//    Produtos atualizarProduto(Long id, Produtos produto);
//    void deletarProduto(Long id);
    List<ListarProdutosDto> listarTodosProdutos();
}
