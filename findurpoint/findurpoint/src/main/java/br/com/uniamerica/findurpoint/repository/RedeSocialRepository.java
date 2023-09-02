package br.com.uniamerica.findurpoint.repository;

import br.com.uniamerica.findurpoint.entity.RedeSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedeSocialRepository extends JpaRepository<RedeSocial, Long> {

    public List<RedeSocial> findByNome(@Param("nome") final String nome);
    
}
