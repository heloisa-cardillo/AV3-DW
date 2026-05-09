package com.autobots.automanager.credenciais;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Credencial extends RepresentationModel<Credencial> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date criacao;
    @Column
    private Date ultimoAcesso;
    @Column(nullable = false)
    private boolean inativo;
}
