package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregorio.springboot.backend.starwars.models.dao.IplanetsDAO;
import com.gregorio.springboot.backend.starwars.models.entity.Planets;

@Service
public class PlanetsServiceImpl implements IplanetsService {

	@Autowired
	private IplanetsDAO iPlanetsDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Planets> findAll() {
		return (List<Planets>)iPlanetsDao.findAll();
	}

	@Override
	public Planets save(Planets Planets) {
		return iPlanetsDao.save(Planets);
	}

	@Override
	@Transactional(readOnly=true)
	public Planets findById(Integer id) {
		return iPlanetsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iPlanetsDao.deleteById(id);

	}

}
