package com.guilherme.explorandomarte;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondasRepository extends CrudRepository<Sonda, Long> {
    
}
