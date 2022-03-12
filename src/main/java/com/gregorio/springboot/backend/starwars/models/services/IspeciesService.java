package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import com.gregorio.springboot.backend.starwars.models.entity.Species;

public interface IspeciesService {
	public List<Species> findAll();
	public Species save(Species Species);
	public Species findById(Integer id);
	public void delete(Integer id);

}
