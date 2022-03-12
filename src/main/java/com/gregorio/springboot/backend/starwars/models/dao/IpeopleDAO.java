package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.People;

public interface IpeopleDAO extends CrudRepository<People, Integer>{

}
