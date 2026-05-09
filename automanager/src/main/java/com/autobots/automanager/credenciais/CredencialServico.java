package com.autobots.automanager.credenciais;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entitades.*;
import com.autobots.automanager.repositorios.RepositorioUsuario;

@Service
public class CredencialServico {

    @Autowired private CredencialRepositorio repositorio;
    @Autowired private RepositorioUsuario repositorioUsuario;

    public List<Credencial> obterCredenciais() {
        return repositorio.findAll();
    }

    public Credencial obterCredencial(long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Credencial nao encontrada: " + id));
    }

    public Credencial cadastrarSenha(CredencialUsuarioSenhaDto dto) {
        Usuario usuario = repositorioUsuario.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado: " + dto.getUsuarioId()));
        CredencialUsuarioSenha credencial = new CredencialUsuarioSenha();
        credencial.setCriacao(dto.getCriacao());
        credencial.setUltimoAcesso(dto.getUltimoAcesso());
        credencial.setInativo(dto.isInativo());
        credencial.setNomeUsuario(dto.getNomeUsuario());
        credencial.setSenha(dto.getSenha());
        repositorio.save(credencial);
        usuario.getCredenciais().add(credencial);
        repositorioUsuario.save(usuario);
        return credencial;
    }

    public Credencial cadastrarCodigo(CredencialCodigoBarraDto dto) {
        Usuario usuario = repositorioUsuario.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado: " + dto.getUsuarioId()));
        CredencialCodigoBarra credencial = new CredencialCodigoBarra();
        credencial.setCriacao(dto.getCriacao());
        credencial.setUltimoAcesso(dto.getUltimoAcesso());
        credencial.setInativo(dto.isInativo());
        credencial.setCodigo(dto.getCodigo());
        repositorio.save(credencial);
        usuario.getCredenciais().add(credencial);
        repositorioUsuario.save(usuario);
        return credencial;
    }

    public void excluir(long id) {
        repositorio.delete(obterCredencial(id));
    }
}
