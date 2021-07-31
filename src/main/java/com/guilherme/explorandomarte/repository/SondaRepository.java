package com.guilherme.explorandomarte.repository;

import com.guilherme.explorandomarte.entity.Sonda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondaRepository extends CrudRepository<Sonda, Long> {
    
}
