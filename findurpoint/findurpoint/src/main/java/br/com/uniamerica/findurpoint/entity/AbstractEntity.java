package br.com.uniamerica.findurpoint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {


    @Id
    @Getter @Setter
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;


}
