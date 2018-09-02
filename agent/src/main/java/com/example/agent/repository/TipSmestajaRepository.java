package com.example.agent.repository;

import com.example.agent.model.TipSmestaja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipSmestajaRepository extends JpaRepository<TipSmestaja,Long> {
    TipSmestaja findTipSmestajaByBekendId(Long id);
}
