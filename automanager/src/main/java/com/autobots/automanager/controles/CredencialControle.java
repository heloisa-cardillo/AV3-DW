package com.autobots.automanager.controles;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.credenciais.Credencial;
import com.autobots.automanager.credenciais.CredencialCodigoBarraDto;
import com.autobots.automanager.credenciais.CredencialServico;
import com.autobots.automanager.credenciais.CredencialUsuarioSenhaDto;

@RestController
@RequestMapping("/credencial")
public class CredencialControle {

    @Autowired
    private CredencialServico servico;

    @GetMapping("/{id}")
    public ResponseEntity<Credencial> obterCredencial(@PathVariable long id) {
        Credencial credencial = servico.obterCredencial(id);
        adicionarLinks(credencial);
        return new ResponseEntity<>(credencial, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Credencial>> obterCredenciais() {
        List<Credencial> credenciais = servico.obterCredenciais();
        if (credenciais.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        credenciais.forEach(c -> {
            Link self = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CredencialControle.class).obterCredencial(c.getId())).withSelfRel();
            c.add(self);
        });
        return new ResponseEntity<>(credenciais, HttpStatus.OK);
    }

    @PostMapping("/cadastro/senha")
    public ResponseEntity<Credencial> cadastrarSenha(@RequestBody CredencialUsuarioSenhaDto dto) {
        Credencial credencial = servico.cadastrarSenha(dto);
        adicionarLinks(credencial);
        return new ResponseEntity<>(credencial, HttpStatus.CREATED);
    }

    @PostMapping("/cadastro/codigo")
    public ResponseEntity<Credencial> cadastrarCodigo(@RequestBody CredencialCodigoBarraDto dto) {
        Credencial credencial = servico.cadastrarCodigo(dto);
        adicionarLinks(credencial);
        return new ResponseEntity<>(credencial, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable long id) {
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void adicionarLinks(Credencial credencial) {
        credencial.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CredencialControle.class).obterCredencial(credencial.getId())).withSelfRel());
        credencial.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CredencialControle.class).obterCredenciais()).withRel("credenciais"));
    }
}
