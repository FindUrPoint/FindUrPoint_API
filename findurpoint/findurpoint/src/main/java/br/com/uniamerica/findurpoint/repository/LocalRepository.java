package br.com.uniamerica.findurpoint.repository;

import br.com.uniamerica.findurpoint.entity.Local;
import br.com.uniamerica.findurpoint.entity.RedeSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {


//    @Query(value = "select * from tb")
//    public List<RedeSocial> findById(@Param("id") final Long id);
//
    public List<Local> findByNome(@Param("nome") final String nome);

}
