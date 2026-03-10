package com.estudo.npi.demo.services.impl;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.ProdutosMapper;
import com.estudo.npi.demo.model.Produtos;
import com.estudo.npi.demo.repository.ProdutosRepository;
import com.estudo.npi.demo.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private ProdutosMapper produtosMapper;

    @Override
    @Transactional
    public CriarProdutoDto criarProduto(CriarProdutoDto produto) {
        Produtos produtoCriar = produtosMapper.toEntity(produto);
        Produtos produtoSalvo = produtosRepository.save(produtoCriar);

        return produtosMapper.toDTO(produtoSalvo);
    }

    @Override
    public List<CriarProdutoDto> listarTodosProdutos() {
        List<Produtos> produtos = produtosRepository.findAll();

        return produtos.stream()
                .map(produtosMapper::toDTO)
                .toList();
    }
}
