package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregorio.springboot.backend.starwars.models.dao.IstarshipsDAO;
import com.gregorio.springboot.backend.starwars.models.entity.Starships;

@Service
public class StarshipsServiceImpl implements IstarshipsService {

	@Autowired
	private IstarshipsDAO iStarshipsDao;

	@Override
	@Transactional(readOnly=true)
	public List<Starships> findAll() {
		return (List<Starships>) iStarshipsDao.findAll();
	}

	@Override
	@Transactional
	public Starships save(Starships Starships) {
		return iStarshipsDao.save(Starships);
	}

	@Override
	@Transactional(readOnly=true)
	public Starships findById(Integer id) {
		return iStarshipsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iStarshipsDao.deleteById(id);		
	}

	
}
