package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user", schema = "findurpoint")
public class User extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Getter @Setter
    @Column(name = "senha", nullable = false, length = 10)
    private String senha;

    @Getter @Setter
    @Column(name = "confirmacaoSenha", nullable = false)
    private String confirmacaoSenha;

    @Getter @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "cpf", nullable = false, length = 13)
    private String cpf;


}
