package br.com.uniamerica.findurpoint.controller;


import br.com.uniamerica.findurpoint.entity.Categoria;
import br.com.uniamerica.findurpoint.entity.Contato;
import br.com.uniamerica.findurpoint.entity.RedeSocial;
import br.com.uniamerica.findurpoint.repository.RedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/redessociais")
public class RedeSocialController {

    @Autowired
    private RedeSocialRepository redeSocialRepository;

    @GetMapping
    public ResponseEntity<List<RedeSocial>> findAll() {
        return ResponseEntity.ok().body(this.redeSocialRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody RedeSocial redeSocial
    ){
        this.redeSocialRepository.save(redeSocial);
        return ResponseEntity.ok().body("Rede Social Cadastrado com Sucesso");
    }

    @DeleteMapping("/delete/{idRedeSocial}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long idRedeSocial,
            @RequestBody final RedeSocial redeSocial
    ){
        this.redeSocialRepository.delete(redeSocial);
        return  ResponseEntity.ok().body("Rede Social Deletado com Sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final RedeSocial redeSocial
    ){
        if (id.equals(redeSocial.getId())) {
            this.redeSocialRepository.save(redeSocial);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

   // @PutMapping("/update/{idRedeSocial}")
   // public  ResponseEntity<?> update(
     //       @PathVariable Long idRedeSocial,
       //     @RequestBody RedeSocial redeSocial
   // ){
     //   try{
       //     this.redeSocialRepository.update(idRedeSocial ,redeSocial);
         //   return ResponseEntity.ok().body("Rede Social Atualizada com Sucesso");
        //}  catch (Exception e){
          //  return ResponseEntity.badRequest().body(e.getMessage());
       // }

    //}

}



