package br.com.uniamerica.findurpoint.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    public List<Categoria> findByNome(@Param("nome") final String nome);

    //Void update(Long idCategoria, Categoria categoria);
}
