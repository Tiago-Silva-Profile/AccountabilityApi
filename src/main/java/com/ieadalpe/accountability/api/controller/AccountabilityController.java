package com.ieadalpe.accountability.api.controller;

import com.ieadalpe.accountability.api.model.Accountability;
import com.ieadalpe.accountability.api.repository.AccountabilityRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class AccountabilityController {

    @Autowired
    private AccountabilityRepository repository;

    @PostMapping
    public Accountability create(@RequestBody Accountability prestacao) {
        return repository.save(prestacao);
    }

    @GetMapping
    @ApiOperation(value = "Busca todos os registros", notes = "Retorna todos os registros")
    public List<Accountability> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um registro por ID", notes = "Busca um registro por ID")
    public Optional<Accountability> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Accountability update(@PathVariable Long id, @RequestBody Accountability prestacao) {
        // ... lógica para atualizar a prestação de contas
        return repository.save(prestacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
