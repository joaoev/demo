package com.estudo.npi.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeCategoria;
}
