package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_comentarios", schema = "findurpoint")
public class Comentario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "descricao_comentario", nullable = false, length = 255)
    private String descricaoComentario;

    @Getter @Setter
    @Column(name = "data")
    private LocalDateTime data;


    @Getter @Setter
    @JoinColumn(name = "id_locais")
    @ManyToOne
    private Local local;

    @Getter @Setter
    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;


//    @Getter @Setter
//    @ManyToMany
//    @JoinColumn(name = "local_id")
//    private Local local;

}
