package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_locais" , schema = "findurpoint")
public class Local extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome" ,length = 30, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "foto")
    private String foto;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, unique = true)
    private String telefone;

    @Getter @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "descricaoLocal", length = 200)
    private String descricaoLocal;

    @Getter @Setter
    @Column(name = "endereco" , length = 20, nullable = false)
    private String endereco;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "td_rede_social_local", schema = "findurpoint",
        joinColumns = { @JoinColumn(name = "local_id") },
        inverseJoinColumns = { @JoinColumn(name = "rede_social_id") }
    )
    private List<RedeSocial> redeSocial;

    @Getter @Setter
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    @Getter @Setter
    @OneToMany
    private List<Comentario> comentario;
}
