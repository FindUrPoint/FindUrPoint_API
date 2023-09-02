package br.com.uniamerica.findurpoint.controller;


import br.com.uniamerica.findurpoint.entity.*;
import br.com.uniamerica.findurpoint.repository.LocalRepository;
import br.com.uniamerica.findurpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(this.userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody User user
    ) {
        this.userRepository.save(user);
        return  ResponseEntity.ok().body("Usuario Cadastrado com Sucesso");
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long idUser,
            @RequestBody final User user
    ) {
        this.userRepository.delete(user);
        return ResponseEntity.ok().body("Usuario Deletado com Sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final User user
    ){
        if (id.equals(user.getId())) {
            this.userRepository.save(user);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


}
