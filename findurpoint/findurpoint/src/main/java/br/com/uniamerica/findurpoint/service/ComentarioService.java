package br.com.uniamerica.findurpoint.service;

import br.com.uniamerica.findurpoint.entity.Comentario;
import br.com.uniamerica.findurpoint.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

   // public void atualizar(final Long id, final Comentario comentario)

}
