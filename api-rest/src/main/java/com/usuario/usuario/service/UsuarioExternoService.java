package com.usuario.usuario.service;

import com.usuario.usuario.model.UsuarioExterno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface UsuarioExternoService {

    UsuarioExterno salvarOuAtualizar(UsuarioExterno usuarioExterno);

    Optional<UsuarioExterno> findByCpf(String cpf);

    void delete(String id);

    UsuarioExterno findByEmail(String email);

    Page<UsuarioExterno> findAll(int page, int count);

    Page<UsuarioExterno> listarUsuarios(int page, int count);

    //Page<UsuarioExterno> findByNumber(int page, int count,Integer number);

    List<UsuarioExterno> findAll();

    Page<UsuarioExterno> findByFiltros(int page, int count,String nome ,String situacao, String perfilId);
}
