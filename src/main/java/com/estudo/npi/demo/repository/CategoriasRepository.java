package com.estudo.npi.demo.repository;

import com.estudo.npi.demo.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}