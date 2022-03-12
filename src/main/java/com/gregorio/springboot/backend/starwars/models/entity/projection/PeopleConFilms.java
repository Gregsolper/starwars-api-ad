package com.gregorio.springboot.backend.starwars.models.entity.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gregorio.springboot.backend.starwars.models.entity.People;
import com.gregorio.springboot.backend.starwars.models.entity.Films;
/**
 * Proyección "confilms" se utiliza con la api semi automática
 * 
 * @author Gregorio Solís Pérez
 * Febrero 2022
 *
 */
@Projection (name="confilms", types= {People.class})
public interface PeopleConFilms {
	
	public int getCodigo();
	public String getName();
	public Set<Films> getFilmses();
}
