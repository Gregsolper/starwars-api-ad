package com.gregorio.springboot.backend.starwars.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gregorio.springboot.backend.starwars.models.entity.People; 
//@RepositoryRestResource (path="people",collectionResourceRel ="people")
public interface IPeople extends JpaRepository<People, Integer> {

}
