package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_contato", schema = "findurpoint")
public class Contato extends AbstractEntity{

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local_id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Getter @Setter
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 16)
    private String telefone;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status_contato")
    private StatusContato statusContato;

    @Getter @Setter
    @Column(name = "observacao", nullable = false, length = 255)
    private String observacao;

    public Contato(User user, Local local) {
        super();
    }
}
