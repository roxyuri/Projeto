package com.usuario.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FUNCAO_USUARIO_EXTERNO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncaoUsuarioExterno implements Serializable {

    @Id
    @Column(name = "CO_FUNCAO")
    @NonNull
    private Long funcao;

    @Column(name = "NO_FUNCAO")
    @NonNull
    private String nome;


}
