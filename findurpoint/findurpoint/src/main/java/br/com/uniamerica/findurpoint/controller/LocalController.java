package br.com.uniamerica.findurpoint.controller;

import br.com.uniamerica.findurpoint.entity.Local;
import br.com.uniamerica.findurpoint.repository.LocalRepository;
import br.com.uniamerica.findurpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/local")
public class LocalController {

    @Autowired
    public LocalRepository localRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Local>> findAll(){
        return ResponseEntity.ok().body(this.localRepository.findAll());
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Local>> findByNome(
            @RequestParam("/locaisnome") final String nome
    ){
        return ResponseEntity.ok().body(this.localRepository.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Local local){
        this.localRepository.save(local);
        return ResponseEntity.ok().body("Registro adicionado com exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Local local
    ){
        if (id.equals(local.getId())) {
            this.localRepository.save(local);
        }
        else {
        return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Local local
    ){
        if (id.equals(local.getId()) && !this.localRepository.findById(id).isEmpty()) {
            this.localRepository.delete(local);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro excluido com exito...");
    }

}
