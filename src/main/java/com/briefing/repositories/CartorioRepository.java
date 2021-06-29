package com.briefing.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briefing.entities.CartorioEntity;

@Repository
@Transactional
public interface CartorioRepository extends CrudRepository<CartorioEntity, Long> {

}
