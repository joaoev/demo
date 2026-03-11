package com.estudo.npi.demo.services;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.EditarProdutoDto;
import com.estudo.npi.demo.dto.ListarProdutosDto;
import java.util.List;

public interface ProdutosService {
    CriarProdutoDto criarProduto(CriarProdutoDto produto);
    List<ListarProdutosDto> listarTodosProdutos();
    ListarProdutosDto editarProduto(Long id, EditarProdutoDto editarProdutoDto);
    void deletarProduto(Long id);
}
