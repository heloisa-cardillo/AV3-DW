package com.autobots.automanager.entitades;

import java.util.Date;
import jakarta.persistence.*;
import com.autobots.automanager.enumeracoes.TipoDocumento;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
public class Documento extends RepresentationModel<Documento> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private TipoDocumento tipo;
    @Column(nullable = false)
    private Date dataEmissao;
    @Column(unique = true, nullable = false)
    private String numero;
}
