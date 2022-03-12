package com.gregorio.springboot.backend.starwars.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregorio.springboot.backend.starwars.models.dto.CatalogoDTO;
import com.gregorio.springboot.backend.starwars.models.entity.Films;
import com.gregorio.springboot.backend.starwars.models.entity.People;
import com.gregorio.springboot.backend.starwars.models.entity.Planets;
import com.gregorio.springboot.backend.starwars.models.entity.Species;
import com.gregorio.springboot.backend.starwars.models.entity.Starships;
import com.gregorio.springboot.backend.starwars.models.entity.Vehicles;
import com.gregorio.springboot.backend.starwars.models.services.IfilmsService;
import com.gregorio.springboot.backend.starwars.models.services.IpeopleService;
import com.gregorio.springboot.backend.starwars.models.services.IplanetsService;
import com.gregorio.springboot.backend.starwars.models.services.IspeciesService;
import com.gregorio.springboot.backend.starwars.models.services.IstarshipsService;
import com.gregorio.springboot.backend.starwars.models.services.IvehiclesService;

/**
 * 
 * Ejercicio de Programación 
 * Acceso de Datos
 * Mapeo Objeto Relacional
 * 
 * REST Controller dedicado a atender las solicitudes de obtención de CATALOGOS
 * 
 * Febrero 2022
 * 
 * Profersor: FRANCISCO MIGUEL GARCIA MUÑOZ
 * 
 * @author  Gregorio Solís Pérez
 *
 */
@CrossOrigin (origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

	@Autowired 
	IpeopleService peopleService;
	@Autowired
	IplanetsService planetsService;
	@Autowired
	IstarshipsService starshipsService;
	@Autowired
	IfilmsService filmsService;
	@Autowired
	IspeciesService speciesService;
	@Autowired
	IvehiclesService vehiclesService;
	
	@GetMapping({"/people"})
	public ResponseEntity<?> getAllPeople () {
		List<People> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = peopleService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping("/starships")
	public ResponseEntity<?> getAllStarships () {
		List<Starships> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = starshipsService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}

	@GetMapping({"/planets"})
	public ResponseEntity<?> getAllPlanets () {
		List<Planets> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = planetsService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}

	@GetMapping({"/films"})
	public ResponseEntity<?> getAllFilms () {
		List<Films> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = filmsService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping({"/species"})
	public ResponseEntity<?> getAllSpecies () {
		List<Species> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = speciesService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping({"/vehicles"})
	public ResponseEntity<?> getAllVehicles () {
		List<Vehicles> lista= null;
		Map<String,Object> response = new HashMap<>();
		try {
			lista = vehiclesService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lista==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<CatalogoDTO> listDto = new ArrayList<CatalogoDTO>();
		lista.forEach(p-> listDto.add(new CatalogoDTO(p))  );
		
		return new ResponseEntity<List<CatalogoDTO>>(listDto,HttpStatus.OK);
	}
	
	
}
