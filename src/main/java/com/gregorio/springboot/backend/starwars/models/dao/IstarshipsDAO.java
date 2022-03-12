/**
 * 
 */
package com.gregorio.springboot.backend.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gregorio.springboot.backend.starwars.models.entity.Starships;

public interface IstarshipsDAO extends CrudRepository<Starships, Integer> {
	


}
