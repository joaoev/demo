package com.estudo.npi.demo.services.impl;

import com.estudo.npi.demo.dto.CriarProdutoDto;
import com.estudo.npi.demo.dto.EditarProdutoDto;
import com.estudo.npi.demo.dto.ListarProdutosDto;
import com.estudo.npi.demo.mappers.ProdutosMapper;
import com.estudo.npi.demo.model.Categorias;
import com.estudo.npi.demo.model.Produtos;
import com.estudo.npi.demo.repository.CategoriasRepository;
import com.estudo.npi.demo.repository.ProdutosRepository;
import com.estudo.npi.demo.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProdutoServiceImpl implements ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private ProdutosMapper produtosMapper;

    @Override
    @Transactional
    public CriarProdutoDto criarProduto(CriarProdutoDto produto) {
        Produtos produtoCriar = produtosMapper.toEntity(produto);

        Set<Long> categoriasIds = produto.categoriasIds() == null ? Set.of() : produto.categoriasIds();
        List<Categorias> categoriasEncontradas = categoriasRepository.findAllById(categoriasIds);

        if (categoriasEncontradas.size() != categoriasIds.size()) {
            throw new RuntimeException("Uma ou mais categorias informadas nao existem");
        }

        produtoCriar.setCategorias(new HashSet<>(categoriasEncontradas));
        Produtos produtoSalvo = produtosRepository.save(produtoCriar);

        return produtosMapper.toDTO(produtoSalvo);
    }

    @Override
    @Transactional
    public List<ListarProdutosDto> listarTodosProdutos() {
        List<Produtos> produtos = produtosRepository.findAll();

        return produtos.stream()
                .map(produtosMapper::toListarDto)
                .toList();
    }

    @Override
    @Transactional
    public ListarProdutosDto editarProduto(Long id, EditarProdutoDto editarProdutoDto) {
        Produtos produtoExistente = produtosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoExistente.setNome(editarProdutoDto.nome());
        produtoExistente.setDescricao(editarProdutoDto.descricao());
        produtoExistente.setPreco(editarProdutoDto.preco());

        Set<Long> categoriasIds = editarProdutoDto.categoriasIds() == null ? Set.of() : editarProdutoDto.categoriasIds();
        List<Categorias> categoriasEncontradas = categoriasRepository.findAllById(categoriasIds);

        if (categoriasEncontradas.size() != categoriasIds.size()) {
            throw new RuntimeException("Uma ou mais categorias informadas nao existem");
        }

        produtoExistente.setCategorias(new HashSet<>(categoriasEncontradas));
        Produtos produtoAtualizado = produtosRepository.save(produtoExistente);

        return produtosMapper.toListarDto(produtoAtualizado);
    }

    @Override
    @Transactional
    public void deletarProduto(Long id) {
        if (!produtosRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }

        produtosRepository.deleteById(id);
    }
}
