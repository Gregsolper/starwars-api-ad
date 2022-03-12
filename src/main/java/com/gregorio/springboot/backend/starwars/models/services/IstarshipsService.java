package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import com.gregorio.springboot.backend.starwars.models.entity.Starships;

public interface IstarshipsService {
	
	public List<Starships> findAll();
	public Starships save(Starships Starships);
	public Starships findById(Integer id);
	public void delete(Integer id);

}
