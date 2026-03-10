package com.estudo.npi.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categorias")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeCategoria;
}
