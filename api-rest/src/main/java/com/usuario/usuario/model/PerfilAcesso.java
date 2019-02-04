package com.usuario.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERFIL_ACESSO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfilAcesso implements Serializable {

    @Id
    @Column(name = "IC_PERFIL_ACESSO")
    @NonNull
    private String id;

    @Column(name = "DESCRICAO")
    @NonNull
    private String descricao;

}

