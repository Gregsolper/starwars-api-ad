package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.Films;

public interface IfilmsDAO extends CrudRepository<Films, Integer> {

}
