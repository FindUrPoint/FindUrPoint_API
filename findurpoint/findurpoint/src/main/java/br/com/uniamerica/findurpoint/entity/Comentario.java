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
    @JoinColumn(name = "nomeUsuario")
    @ManyToOne
    private User usuario;

    @Getter @Setter
    @Column(name = "comentarioTexto", length = 255)
    private String comentarioTexto;

    @Getter @Setter
    @Column(name = "data")
    private LocalDateTime data;

}
