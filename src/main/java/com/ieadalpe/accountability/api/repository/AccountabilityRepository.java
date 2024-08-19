package com.ieadalpe.accountability.api.repository;

import com.ieadalpe.accountability.api.model.Accountability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AccountabilityRepository extends JpaRepository<Accountability, Long> {
    List<Accountability> findByOrigemAndDataBetween(String origem, Date dataInicio, Date dataFim);
}
