package br.com.uniamerica.findurpoint.repository;

import br.com.uniamerica.findurpoint.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByNome(@Param("nome") final String nome);

}