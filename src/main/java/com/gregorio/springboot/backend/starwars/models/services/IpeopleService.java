package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;


import com.gregorio.springboot.backend.starwars.models.entity.People;

public interface IpeopleService {
	
	public List<People> findAll();
	public People save(People People);
	public People findById(Integer id);
	public void delete(Integer id);

}
