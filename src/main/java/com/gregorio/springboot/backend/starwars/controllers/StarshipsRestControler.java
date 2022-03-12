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

import com.gregorio.springboot.backend.starwars.models.dto.StarshipsDTO;
import com.gregorio.springboot.backend.starwars.models.entity.Films;
import com.gregorio.springboot.backend.starwars.models.entity.People;
import com.gregorio.springboot.backend.starwars.models.entity.Starships;
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
 * REST Controller dedicado a atender las solicitudes CRUD de la entidad STARSHIPS
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
@RequestMapping("/api/starships")
public class StarshipsRestControler {
	
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
		List<Starships> listStarships= null;
		Map<String,Object> response = new HashMap<>();
		try {
			listStarships = starshipsService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (listStarships==null) {
			response.put("mensaje","No se pede consultar starships en la BD");
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		List<StarshipsDTO> listDto = new ArrayList<StarshipsDTO>();
		listStarships.forEach(p-> listDto.add(new StarshipsDTO(p))  );
		
		return new ResponseEntity<List<StarshipsDTO>>(listDto,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Integer id) {
		Starships starships = null;
		Map<String,Object> response = new HashMap<>();
		try {
			starships = starshipsService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error en la consulta a la BD");
			response.put("error:",e.getMessage()
					.concat(" : ")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (starships==null) {
			response.put("mensaje","El starships ".concat(id.toString()).concat(" no existe en la BD"));
			return new ResponseEntity <Map<String,Object>> (response,HttpStatus.NOT_FOUND);
		}
		StarshipsDTO dto = new StarshipsDTO(starships);
		return new ResponseEntity<StarshipsDTO>(dto,HttpStatus.OK);
	}
	

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> insertar (@Valid @RequestBody StarshipsDTO starshipsDto, BindingResult result) {
		Starships starshipsNew = null;
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
			starshipsNew=armaStarships("insertar",starshipsDto);
			starshipsService.save(starshipsNew);
			
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se ha insertado correctamente");
		response.put("starships", new StarshipsDTO(starshipsNew));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
	}
	
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody StarshipsDTO starshipsDto, @PathVariable 
			Integer id, BindingResult result){
		
		Starships starshipsActual = null;
		Starships starshipsUpdated = null;
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
			
			starshipsActual = starshipsService.findById(id); // El starships puede existir o no
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos: "+id);
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(starshipsActual==null) { // No existe en la base de datos
			response.put("mensaje", "El starships con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// Si llegamos aquí es que el starships que queremos modificar SI existe
		try {
			starshipsUpdated = starshipsService.save(armaStarships("update",starshipsDto));
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El starships se ha modificado correctamente");
		response.put("starships", new StarshipsDTO (starshipsUpdated));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id) {
		Map<String,Object> response = new HashMap<>();
		try {
			starshipsService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el id");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	private Starships armaStarships(String operacion, StarshipsDTO starshipsDto) {
		Starships starships = new Starships (starshipsDto);
		if ( operacion.equalsIgnoreCase("insertar"))  {
			Optional<Integer> maxCod = starshipsService.findAll().stream().map(p->p.getCodigo()).max((c1,c2)->Integer.compareUnsigned(c1, c2));
			if (maxCod.isPresent())
				starships.setCodigo((maxCod.get()+1));
		}
		//Films
		Set<Films> filmses = new HashSet<Films>(0);
		starshipsDto.getFilmses().forEach(s->filmses.add(filmsService.findById(s)));
		starships.setFilmses(filmses);
		//Peoples
		Set<People> gente = new HashSet<People>(0);
		starshipsDto.getPeoples().forEach(s->{
				gente.add(peopleService.findById(s)); 
			});
		starships.setPeoples(gente);
		
		return starships;
	}

}
