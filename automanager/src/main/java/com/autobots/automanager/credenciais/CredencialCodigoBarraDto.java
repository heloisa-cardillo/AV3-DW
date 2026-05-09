package com.autobots.automanager.credenciais;

import java.util.Date;
import lombok.Data;

@Data
public class CredencialCodigoBarraDto {
    private Date criacao;
    private Date ultimoAcesso;
    private boolean inativo;
    private long codigo;
    private Long usuarioId;
}
