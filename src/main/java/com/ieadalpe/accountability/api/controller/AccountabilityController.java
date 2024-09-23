package com.ieadalpe.accountability.api.controller;

import com.ieadalpe.accountability.api.exception.ResourceNotFoundException;
import com.ieadalpe.accountability.api.model.Accountability;
import com.ieadalpe.accountability.api.repository.AccountabilityRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
public class AccountabilityController {

    @Autowired
    private AccountabilityRepository repository;

    private static final Logger logger = Logger.getLogger(String.valueOf(AccountabilityRepository.class));

    @PostMapping
    public Accountability create(@RequestBody Accountability prestacao) {

        Optional<Accountability> existingPrestacao = repository.findByNumeroTalao(prestacao.getNumeroTalao());

        if (existingPrestacao.isPresent()) {

            logger.info("Tentativa de anexar um talão já existente. Número do Talão: "
                    + prestacao.getNumeroTalao() + " | Prestação já existente: "
                    + existingPrestacao.get());

            // Retorna uma resposta de erro se o número do talão já estiver em uso
            return null;
        }

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
        // Busca a entidade existente no banco de dados pelo ID
        Accountability updateAccountability = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prestação de contas não encontrada com o id " + id));

        // Atualiza os campos que foram informados, mantendo os valores anteriores nos campos não alterados
        if (prestacao.getData() != null) {
            updateAccountability.setData(prestacao.getData());
        }

        if (prestacao.getValor() != null) {
            updateAccountability.setValor(prestacao.getValor());
        }

        if (prestacao.getOrigem() != null) {
            updateAccountability.setOrigem(prestacao.getOrigem());
        }

        if (prestacao.getObservacao() != null){
            prestacao.setObservacao(prestacao.getObservacao());
        }

        // Salva a entidade com os campos atualizados
        return repository.save(updateAccountability);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
