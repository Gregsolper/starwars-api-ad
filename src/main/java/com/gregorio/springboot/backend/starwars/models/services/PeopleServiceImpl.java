package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gregorio.springboot.backend.starwars.models.dao.IpeopleDAO;
import com.gregorio.springboot.backend.starwars.models.entity.People;

@Service
public class PeopleServiceImpl implements IpeopleService {

	@Autowired
	private IpeopleDAO iPeopleDao;

	@Override
	@Transactional(readOnly=true)
	public List<People> findAll() {
		return (List<People>) iPeopleDao.findAll();
	}

	@Override
	@Transactional
	public People save(People People) {
		return iPeopleDao.save(People);
	}

	@Override
	@Transactional(readOnly=true)
	public People findById(Integer id) {
		return iPeopleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iPeopleDao.deleteById(id);		
	}
	
	
}