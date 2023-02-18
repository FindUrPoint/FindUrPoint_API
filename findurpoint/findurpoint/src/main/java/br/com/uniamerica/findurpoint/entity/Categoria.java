package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_categorias", schema = "findurpoint")
public class Categoria extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

}
