package com.ieadalpe.accountability.api.repository;

import com.ieadalpe.accountability.api.model.Accountability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountabilityRepository extends JpaRepository<Accountability, Long> {

    List<Accountability> findByOrigemAndDataBetween(String origem, Date dataInicio, Date dataFim);

    /**
     * Esta sendo verificado se o numero do talão ja foi lançado
     * @param numeroTalao
     * @return
     */
    Optional<Accountability> findByNumeroTalao(String numeroTalao);

}
