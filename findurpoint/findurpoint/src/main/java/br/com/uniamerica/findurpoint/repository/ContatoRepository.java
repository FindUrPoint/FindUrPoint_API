package br.com.uniamerica.findurpoint.repository;

import br.com.uniamerica.findurpoint.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
//
//    public List<Categoria> findByNome(@Param("nome") final String nome);

   // Void update(Long idContato, Contato contato);

    //Void atualizarStatusEmAndamento(Long idContato);

    //Void atualizarStatusRespondido(Long idContato);

    //Void atualizarStatusRecusado(Long idContato);
}

