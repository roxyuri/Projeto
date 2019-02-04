package com.usuario.usuario.service;

import com.usuario.usuario.model.PerfilAcesso;
import com.usuario.usuario.repository.PerfilAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository repository;

    public List<PerfilAcesso> obterTodosOsPerfils() {
        return repository.findAll();
    }
}
