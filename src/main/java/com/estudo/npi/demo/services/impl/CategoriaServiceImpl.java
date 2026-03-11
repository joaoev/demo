package com.estudo.npi.demo.services.impl;

import com.estudo.npi.demo.dto.CriarCategoriaDto;
import com.estudo.npi.demo.dto.ListarCategoriasDto;
import com.estudo.npi.demo.mappers.CategoriasMapper;
import com.estudo.npi.demo.model.Categorias;
import com.estudo.npi.demo.repository.CategoriasRepository;
import com.estudo.npi.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasMapper categoriasMapper;

    @Override
    @Transactional
    public ListarCategoriasDto criarCategoria(CriarCategoriaDto criarCategoriaDto) {
        Categorias categoria = categoriasMapper.toEntity(criarCategoriaDto);
        Categorias categoriaSalva = categoriasRepository.save(categoria);

        return categoriasMapper.toDto(categoriaSalva);
    }

    @Override
    public List<ListarCategoriasDto> listarTodasCategorias() {
        return categoriasMapper.toDtoList(categoriasRepository.findAll());
    }
}
