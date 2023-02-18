package br.com.uniamerica.findurpoint.controller;

import br.com.uniamerica.findurpoint.entity.*;
import br.com.uniamerica.findurpoint.repository.ContatoRepository;
import br.com.uniamerica.findurpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private UserRepository userRepository;

    //visualizar todos os contatos
    @GetMapping
    public ResponseEntity<List<Contato>> findAll(){
        return ResponseEntity.ok().body(this.contatoRepository.findAll());
    }


    //cadastrar contato
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Contato contato
    ) {

        this.contatoRepository.save(contato);
        return ResponseEntity.ok().body("Contato Cadastrado com Sucesso.");
    }

    //deletar contato
//    @DeleteMapping("/delete/{idContato}")
//    public ResponseEntity<?> excluir(
//            @PathVariable final Long idContato,
//            @RequestBody final Contato contato
//    ) {
//        this.contatoRepository.delete(contato);
//        return ResponseEntity.ok().body("Contato Deletado com Sucesso");
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Contato contato
    ){
        if (id.equals(contato.getId())) {
            this.contatoRepository.save(contato);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

    @GetMapping("/contato/{idUser}")
    public ResponseEntity<List<Contato>> findByUserId(
            @PathVariable Long idUser
    ){
        ArrayList<Contato> contatos = (ArrayList<Contato>) this.findAll().getBody();
        User user = this.userRepository.findById(idUser).get();
        ArrayList<Contato>contatosUsuario = new ArrayList<>();
        for (int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getUser_id().equals(user)){
                contatosUsuario.add(contatos.get(i));
            }
        }
        return ResponseEntity.ok().body(contatosUsuario);
    }


//    @PostMapping("/contatar/{idUser}")
//    public ResponseEntity<?> insertContato(
//            @PathVariable Long idUser
//    ) {
//        User user = this.userRepository.findById(idUser).get();
//
//        Contato contato = new Contato(user);
//        this.contatoRepository.save(contato);
//        return  ResponseEntity.ok().body("Contato registrado com Sucesso");
//    }


    //atualizar contato
    //@PutMapping("/update/{idContato}")
    //public ResponseEntity<?> update(
      //      @PathVariable Long idContato,
        //    @RequestBody Contato contato
   // ) {
     //   try {
       //     this.contatoRepository.update(idContato, contato);
         //   return ResponseEntity.ok().body("Contato Atualizado com Sucesso.");
        //} catch (Exception e) {
          //  return ResponseEntity.badRequest().body(e.getMessage());
        //}
   // }


    //atualizar status do contato para em andamento
   // @PutMapping("/status/em-andamento/{idContato}")
    //public ResponseEntity<?> atualizarStatusEmAndamento(@PathVariable("idContato") final Long idContato) {
      //  try{
        //    this.contatoRepository.atualizarStatusEmAndamento(idContato);
        //}
        //catch (Exception e){
          //  return ResponseEntity.badRequest().body(e.getMessage());
        //}
        //return ResponseEntity.ok().body("Status do contato alterado  com sucesso.");
    //}


    //atualizar status do contato para respondido
    //@PutMapping("/status/respondido/{idContato}")
    //public ResponseEntity<?> atualizarStatusRespondido(@PathVariable("idContato") final Long idContato) {
      //  try{
        //    this.contatoRepository.atualizarStatusRespondido(idContato);
        //}
        //catch (Exception e){
          //  return ResponseEntity.badRequest().body(e.getMessage());
        //}
       // return ResponseEntity.ok().body("Status do contato alterado  com sucesso.");
    //}


    //atualizar status do contato para recusado
   // @PutMapping("/status/recusado/{idContato}")
   // public ResponseEntity<?> atualizarStatusRecusado(@PathVariable("idContato") final Long idContato) {
     //   try{
       //     this.contatoRepository.atualizarStatusRecusado(idContato);
       // }
        //catch (Exception e){
          //  return ResponseEntity.badRequest().body(e.getMessage());
        //}
        //return ResponseEntity.ok().body("Status do contato alterado  com sucesso.");
    //}
}
