package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_rede_social", schema = "findurpoint")
public class RedeSocial extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", length = 30)
    private String nome;

}
