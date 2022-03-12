package com.gregorio.springboot.backend.starwars.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gregorio.springboot.backend.starwars.models.dto.PeopleDTO;

import com.gregorio.springboot.backend.starwars.models.entity.Films;
import com.gregorio.springboot.backend.starwars.models.entity.People;
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
 * REST Controller dedicado a atender las solicitudes CRUD de la entidad PEOPLE
 * 
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
@RequestMapping("/api/people")
public class PeopleRestControler {
	
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
	
	
	@GetMapping({"/",""})
	public ResponseEntity<?> getAll () {
		List<People> listPeople= null;
		Map<String,Object> response = new HashMap<>();
		try {
			listPeople = peopleService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (listPeople==null) {
			response.put("mensaje","No se pede consultar people en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<PeopleDTO> listDto = new ArrayList<PeopleDTO>();
		listPeople.forEach(p-> listDto.add(new PeopleDTO(p))  );
		
		return new ResponseEntity<List<PeopleDTO>>(listDto,HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Integer id) {
		People people = null;
		Map<String,Object> response = new HashMap<>();
		try {
			people = peopleService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("eror:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (people==null) {
			response.put("mensaje","El people ".concat(id.toString()).concat(" no existe en la BD"));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		PeopleDTO dto = new PeopleDTO();
		dto.copiar(people);
		return new ResponseEntity<PeopleDTO>(dto,HttpStatus.OK);
	}
	

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> insertar (@Valid @RequestBody PeopleDTO peopleDto, BindingResult result) {
		People peopleNew = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			peopleNew = armaPeople("insertar",peopleDto);
			peopleService.save(peopleNew);
			
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se ha insertado correctamente");
		response.put("people",  new PeopleDTO ( peopleNew));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
	}
	
	
	@PutMapping ("/{id}")
	/*@ResponseStatus(HttpStatus.CREATED)
	public People update (@RequestBody People people,@PathVariable Integer id) {
		People current = peopleService.findById(id);
		current.copiar(people);
		peopleService.save(current);
		return current;
	}*/
	public ResponseEntity<?> update(@Valid @RequestBody PeopleDTO peopleDto, @PathVariable 
			Integer id, BindingResult result){
		
		People peopleActual = null;
		People peopleUpdated = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			peopleActual = peopleService.findById(id); // El people puede existir o no
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(peopleActual==null) { // No existe en la base de datos
			response.put("mensaje", "El people con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// Si llegamos aquí es que el people que queremos modificar SI existe
		try {
			peopleUpdated = peopleService.save(armaPeople("update",peopleDto));
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El people se ha modificado correctamente");
		response.put("people", new PeopleDTO (peopleUpdated));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id) {
		Map<String,Object> response = new HashMap<>();
		try {
			peopleService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el id");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	private People armaPeople(String operacion, PeopleDTO peopleDto) {
		People people = new People (peopleDto);
		if ( operacion.equalsIgnoreCase("insertar"))  {
			Optional<Integer> maxCod = peopleService.findAll().stream().map(p->p.getCodigo()).max((c1,c2)->Integer.compareUnsigned(c1, c2));
			if (maxCod.isPresent())
				people.setCodigo((maxCod.get()+1));
		}
		//   Planets
		people.setPlanets(planetsService.findById(peopleDto.getHomeWorld()));
		// Starships
		Set<Starships> starshipses = new HashSet<Starships>(0);
		peopleDto.getStarshipses().forEach(s->starshipses.add(starshipsService.findById(s)));
		people.setStarshipses(starshipses);
		//Species
		Set<Species> specieses = new HashSet<Species>(0);
		peopleDto.getSpecieses().forEach(s->specieses.add(speciesService.findById(s)));
		people.setSpecieses(specieses);
		//Films
		Set<Films> filmses = new HashSet<Films>(0);
		peopleDto.getFilmses().forEach(s->filmses.add(filmsService.findById(s)));
		people.setFilmses(filmses);
		//Vehicles
		Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);
		peopleDto.getVehicleses().forEach(s->vehicleses.add(vehiclesService.findById(s)));
		people.setVehicleses(vehicleses);
		
		return people;
	}

}
