package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregorio.springboot.backend.starwars.models.dao.IspeciesDAO;
import com.gregorio.springboot.backend.starwars.models.entity.Species;

@Service
public class SpeciesServiceImpl implements IspeciesService {

	@Autowired
	private IspeciesDAO iSpeciesDao;

	@Override
	@Transactional(readOnly=true)
	public List<Species> findAll() {
		return (List<Species>) iSpeciesDao.findAll();
	}

	@Override
	@Transactional
	public Species save(Species Species) {
		return iSpeciesDao.save(Species);
	}

	@Override
	@Transactional(readOnly=true)
	public Species findById(Integer id) {
		return iSpeciesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iSpeciesDao.deleteById(id);		
	}
}
