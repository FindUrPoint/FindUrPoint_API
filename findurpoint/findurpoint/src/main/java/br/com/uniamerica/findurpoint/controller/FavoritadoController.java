package br.com.uniamerica.findurpoint.controller;

import br.com.uniamerica.findurpoint.entity.Favoritado;
import br.com.uniamerica.findurpoint.entity.Local;
import br.com.uniamerica.findurpoint.entity.User;
import br.com.uniamerica.findurpoint.repository.FavoritadoRepository;
import br.com.uniamerica.findurpoint.repository.LocalRepository;
import br.com.uniamerica.findurpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/favoritados")
public class FavoritadoController {

    @Autowired
    private FavoritadoRepository favoritadoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public ResponseEntity<List<Favoritado>> findAll(){
        return ResponseEntity.ok().body(this.favoritadoRepository.findAll());
    }

//    @GetMapping("/{nome}")
//    public ResponseEntity<List<Favoritado>> findAll(
//            @PathVariable("nome") final String nome
//    ){
//        return  ResponseEntity.ok().body(this.favoritadoRepository.findByNome(nome));
//    }
    @GetMapping("/favoritos/{idUser}")
    public ResponseEntity<List<Favoritado>> findByUserId(
            @PathVariable Long idUser
            ){
        ArrayList<Favoritado>favoritados = (ArrayList<Favoritado>) this.findAll().getBody();
        User user = this.userRepository.findById(idUser).get();
        ArrayList<Favoritado>favoritadosUsuario = new ArrayList<>();
        for (int i = 0; i < favoritados.size(); i++){
            if (favoritados.get(i).getUser_id().equals(user)){
                favoritadosUsuario.add(favoritados.get(i));
            }
        }
        return ResponseEntity.ok().body(favoritadosUsuario);
    }

    @DeleteMapping("/delete/{idFavoritado}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long idFavoritado,
            @RequestBody final Favoritado favoritado
    ){
        this.favoritadoRepository.delete(favoritado);
        return ResponseEntity.ok().body("Local Favoritado Deletado com Sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Favoritado favoritado
    ){
        if (id.equals(favoritado.getId())) {
            this.favoritadoRepository.save(favoritado);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Favoritado favoritado
    ) {

        this.favoritadoRepository.save(favoritado);
        return ResponseEntity.ok().body("Categoria Cadastrada com Sucesso.");
    }

    @PostMapping("/favoritar/{idUser}/{idLocal}")
    public ResponseEntity<?> insertFavoritar(
            @PathVariable Long idUser,
            @PathVariable Long idLocal
    ) {
        User user = this.userRepository.findById(idUser).get();
        Local local = this.localRepository.findById(idLocal).get();

        Favoritado favoritado = new Favoritado(user, local);
        this.favoritadoRepository.save(favoritado);
        return  ResponseEntity.ok().body("Local Favoritado com Sucesso");
    }

}
