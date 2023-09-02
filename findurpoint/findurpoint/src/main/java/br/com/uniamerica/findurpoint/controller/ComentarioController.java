package br.com.uniamerica.findurpoint.controller;


import br.com.uniamerica.findurpoint.entity.Comentario;
import br.com.uniamerica.findurpoint.entity.Local;
import br.com.uniamerica.findurpoint.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired  // constructor
    private ComentarioRepository comentarioRepository;

    @GetMapping // puerta get de un servidor
    public ResponseEntity<List<Comentario>> findAll() {
        return ResponseEntity.ok().body(this.comentarioRepository.findByAtivo(true));
    }

    /*  @GetMapping("/{email}") //no puede haber 2 iguales por eso cree otro get con otro path
    public ResponseEntity <List<Comentario>> findAll( // responseentity esta devolviendo la comunicacion padronizado
            @PathVariable("email") final String email // pathvariable
    ) {
        return ResponseEntity.ok().body(this.comentarioRepository.findByEmail(email));
    }*/

    @PostMapping //parse es una comparacion de llaves
    public ResponseEntity<?> cadastrar(@RequestBody final Comentario comentario){ //requestbody padron definido dentro del cuerpo de mi requisicion
        this.comentarioRepository.save(comentario);
        return ResponseEntity.ok().body("registro creado con exito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Comentario comentario
    ){
        if (id.equals(comentario.getId()) && !this.comentarioRepository.findById(id).isEmpty()) {
            this.comentarioRepository.delete(comentario);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro excluido com exito...");
    }
}
