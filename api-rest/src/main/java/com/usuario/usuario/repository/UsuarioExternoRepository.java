package com.usuario.usuario.repository;

import com.usuario.usuario.model.UsuarioExterno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioExternoRepository  extends JpaRepository<UsuarioExterno, String> {

    UsuarioExterno findByEmail(String email);

    Optional<UsuarioExterno> findByCpf(String cpf);

   // Page<UsuarioExterno> findByNumber(Integer number,Pageable pages);

    Page<UsuarioExterno> findByNomeIgnoreCaseContainingAndSituacaoIgnoreCaseContainingAndPerfilIdIgnoreCaseContaining(String nome, String situacao, String perfilId, Pageable pages);

}
