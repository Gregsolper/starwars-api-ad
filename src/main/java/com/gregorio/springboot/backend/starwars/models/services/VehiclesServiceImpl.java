package com.gregorio.springboot.backend.starwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregorio.springboot.backend.starwars.models.dao.IvehiclesDAO;
import com.gregorio.springboot.backend.starwars.models.entity.Vehicles;

@Service
public class VehiclesServiceImpl implements IvehiclesService {

	@Autowired
	private IvehiclesDAO iVehiclesDao;

	@Override
	@Transactional(readOnly=true)
	public List<Vehicles> findAll() {
		return (List<Vehicles>) iVehiclesDao.findAll();
	}

	@Override
	@Transactional
	public Vehicles save(Vehicles Vehicles) {
		return iVehiclesDao.save(Vehicles);
	}

	@Override
	@Transactional(readOnly=true)
	public Vehicles findById(Integer id) {
		return iVehiclesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		iVehiclesDao.deleteById(id);		
	}
}
