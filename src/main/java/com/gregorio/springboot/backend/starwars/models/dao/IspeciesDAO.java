package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.Species;

public interface IspeciesDAO extends CrudRepository<Species, Integer> {

}
