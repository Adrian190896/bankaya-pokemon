package com.bankaya.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaya.pokemon.model.record.RecordModel;

@Repository
public interface RecordRepository extends JpaRepository<RecordModel, Long>{

}
