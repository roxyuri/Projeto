package com.usuario.usuario.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USUARIO_EXTERNO" , uniqueConstraints = {@UniqueConstraint(columnNames={"NU_CPF"})} )
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioExterno implements Serializable {

    @Id
    @Column(name = "NU_CPF")
    private String cpf;

    @Column(name = "NO_USUARIO")
    @NonNull
    private String nome;

    @Column(name = "DE_EMAIL")
    @NonNull
    private String email;

    @Column(name = "NU_TELEFONE")
    private String telefone;

    @Column(name = "IC_SITUACAO")
    @NonNull
    private String situacao;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IC_PERFIL_ACESSO")
    @NonNull
    private PerfilAcesso perfil;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CO_FUNCAO")
    @NonNull
    private FuncaoUsuarioExterno funcao;


}
