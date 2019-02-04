package com.usuario.usuario.service;

import com.usuario.usuario.model.FuncaoUsuarioExterno;
import com.usuario.usuario.repository.FuncaoUsuarioExternoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoUsuarioExternoService {

    @Autowired
    private FuncaoUsuarioExternoRepository repository;

    List<FuncaoUsuarioExterno> obterTodasAsFunoes(){
        return repository.findAll();
    }
}
