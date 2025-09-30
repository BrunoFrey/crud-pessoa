package com.crud.crud_pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    PessoaRepository repo;

    @GetMapping("/pessoas")
    List<Pessoa> verPessoas() {
        return repo.findAll();
    }

    @PostMapping("/pessoas")
    String addPessoa(@RequestBody Pessoa p) {
        repo.save(p);
        return "Usúario cadastrado!";
    }

    @DeleteMapping("/pessoas/{id}")
    String excluirPessoa(@PathVariable Long id) {
        repo.deleteById(id);
        return "Usúario excluído!";
    }
}

interface PessoaRepository extends org.springframework.data.jpa.repository.JpaRepository<Pessoa, Long> {}