package br.com.uniamerica.findurpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_favoritos", schema = "findurpoint")
public class Favoritado extends AbstractEntity{


    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local_id;


}
