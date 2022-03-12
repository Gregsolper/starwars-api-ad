package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import com.gregorio.springboot.backend.starwars.models.entity.Vehicles;

public interface IvehiclesService {
	public List<Vehicles> findAll();
	public Vehicles save(Vehicles Vehicles);
	public Vehicles findById(Integer id);
	public void delete(Integer id);

}
