package com.autobots.automanager.entitades;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
public class Telefone extends RepresentationModel<Telefone> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ddd;
    @Column(nullable = false)
    private String numero;
}
