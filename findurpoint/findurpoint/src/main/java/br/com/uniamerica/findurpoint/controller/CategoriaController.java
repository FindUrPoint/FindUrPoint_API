package br.com.uniamerica.findurpoint.controller;


import br.com.uniamerica.findurpoint.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //visualizar todas categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok().body(this.categoriaRepository.findAll());
    }

    //escolher qual categoria visualizar
    @GetMapping("/{nome}")
    public ResponseEntity<List<Categoria>> findAll(
            @PathVariable("nome") final String nome
    ) {
        return ResponseEntity.ok().body(this.categoriaRepository.findByNome(nome));
    }

    //cadastrar categoria
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Categoria categoria
    ) {

        this.categoriaRepository.save(categoria);
        return ResponseEntity.ok().body("Categoria Cadastrada com Sucesso.");
    }

    //deletar categoria
    @DeleteMapping("/delete/{idCategoria}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long idCategoria,
            @RequestBody final Categoria categoria
    ) {
        this.categoriaRepository.delete(categoria);
        return ResponseEntity.ok().body("Categoria Deletada com Sucesso");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Categoria categoria
    ){
        if (id.equals(categoria.getId())) {
            this.categoriaRepository.save(categoria);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


}
