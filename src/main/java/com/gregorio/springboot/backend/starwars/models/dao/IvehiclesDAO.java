package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.Vehicles;

public interface IvehiclesDAO extends CrudRepository<Vehicles, Integer> {

}
