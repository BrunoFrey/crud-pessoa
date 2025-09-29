package com.crud.crud_pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repo;

    @GetMapping
    public List<Pessoa> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return repo.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return repo.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

interface PessoaRepository extends JpaRepository<Pessoa, Long> {}