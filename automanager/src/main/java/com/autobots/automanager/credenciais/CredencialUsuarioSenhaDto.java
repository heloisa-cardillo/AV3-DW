package com.autobots.automanager.credenciais;

import java.util.Date;
import lombok.Data;

@Data
public class CredencialUsuarioSenhaDto {
    private Date criacao;
    private Date ultimoAcesso;
    private boolean inativo;
    private String nomeUsuario;
    private String senha;
    private Long usuarioId;
}
