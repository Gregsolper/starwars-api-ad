package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import com.gregorio.springboot.backend.starwars.models.entity.Planets;

public interface IplanetsService {
	public List<Planets> findAll();
	public Planets save(Planets Planets);
	public Planets findById(Integer id);
	public void delete(Integer id);

}
