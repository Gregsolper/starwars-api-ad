package com.gregorio.springboot.backend.starwars.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gregorio.springboot.backend.starwars.models.entity.Films;
//@RepositoryRestResource (path="films",collectionResourceRel ="films")
public interface IFilms extends JpaRepository<Films, Integer> {

}

