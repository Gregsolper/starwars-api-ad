package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import com.gregorio.springboot.backend.starwars.models.entity.Films;

public interface IfilmsService {
	public List<Films> findAll();
	public Films save(Films Films);
	public Films findById(Integer id);
	public void delete(Integer id);

}
