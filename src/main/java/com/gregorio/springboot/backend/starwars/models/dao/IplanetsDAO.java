package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.Planets;

public interface IplanetsDAO extends CrudRepository<Planets, Integer> {

}
