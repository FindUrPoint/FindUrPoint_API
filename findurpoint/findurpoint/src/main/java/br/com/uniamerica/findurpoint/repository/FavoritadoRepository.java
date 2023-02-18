package br.com.uniamerica.findurpoint.repository;


import br.com.uniamerica.findurpoint.entity.Favoritado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  java.util.List;

@Repository
public interface FavoritadoRepository extends JpaRepository<Favoritado, Long> {



    //Void update(Long idFavoritado , Favoritado favoritado);
}
