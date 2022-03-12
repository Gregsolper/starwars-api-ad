package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregorio.springboot.backend.starwars.models.dao.IfilmsDAO;
import com.gregorio.springboot.backend.starwars.models.entity.Films;

@Service
public class FilmsServiceImpl implements IfilmsService {

	@Autowired
	private IfilmsDAO iFilmsDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Films> findAll() {
		return (List<Films>) iFilmsDao.findAll();
	}

	@Override
	@Transactional
	public Films save(Films Films) {
		return iFilmsDao.save(Films);
	}

	@Override
	@Transactional(readOnly=true)
	public Films findById(Integer id) {
		return iFilmsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iFilmsDao.deleteById(id);		
	}
}
