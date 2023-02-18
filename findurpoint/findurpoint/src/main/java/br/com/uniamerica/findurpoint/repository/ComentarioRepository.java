// crea conexion directa con la base de datos, es la que permite accesar, accesa al jpa de nuestro proyecto
package br.com.uniamerica.findurpoint.repository;

import br.com.uniamerica.findurpoint.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByAtivo(@Param("ativo") final boolean ativo);
    public List<Comentario> findByEmail(@Param("email") final String email);

}


