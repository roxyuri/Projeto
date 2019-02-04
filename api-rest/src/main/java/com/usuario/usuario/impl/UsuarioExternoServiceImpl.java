package com.usuario.usuario.impl;

import com.usuario.usuario.model.UsuarioExterno;
import com.usuario.usuario.repository.UsuarioExternoRepository;
import com.usuario.usuario.service.UsuarioExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioExternoServiceImpl implements UsuarioExternoService {

    @Autowired
    private UsuarioExternoRepository repository;

    public UsuarioExterno salvarOuAtualizar(UsuarioExterno usuarioExterno) {
        return this.repository.save(usuarioExterno);
    }

    public Optional<UsuarioExterno> findByCpf(String cpf) {

        return this.repository.findByCpf(cpf);
    }

    public void delete(String cpf) {
        this.repository.deleteById(cpf);
    }

    public List<UsuarioExterno> findAll() {
        return this.repository.findAll();
    }

    public Page<UsuarioExterno> findAll(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return this.repository.findAll(pages);
    }

    public Page<UsuarioExterno> listarUsuarios(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return this.repository.findAll(pages);
    }

    public Page<UsuarioExterno> findByFiltros(int page, int count, String nome,String situacao, String perfilId) {
        Pageable pages = PageRequest.of(page, count);
        return this.repository.findByNomeIgnoreCaseContainingAndSituacaoIgnoreCaseContainingAndPerfilIdIgnoreCaseContaining(nome,situacao,perfilId,pages);
    }

    @Override
    public UsuarioExterno findByEmail(String email) {
        return this.repository.findByEmail(email);
    }


}
