package com.gregorio.springboot.backend.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * Ejercicio de Programación 
 * Acceso de Datos
 * Mapeo Objeto Relacional
 * 
 * Febrero 2022
 * 
 * Profersor: FRANCISCO MIGUEL GARCIA MUÑOZ
 * 
 * @author  Gregorio Solís Pérez
 *
 * Se ofrece un servicio REST
 * 
 * 	Catalogos : api/catalogos  : GETs para obtener los catalogos
 * 	People	  : api/people     : Servicios CRUD para la entidad PEOPLE
 * 	Starships : api/starships  : Servicios CRUD para la entidad STARSHIPS
 * 
 * 	Utilizando el Mapeo Objeto Relacional
 *  Resolviendo consultas mediante DTO
 *  
 *  Implementación de API semi automática para la consulta de 
 *  	FILMS 	: apiauto/filmeses
 *  	PEOPLE 	: apiauto/peoples
 *  para la consulta de PEOPLE-FILMS
 *  
 * 		
 */
@SpringBootApplication
public class SpringBootStarwarsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarwarsBackendApplication.class, args);
	}

}
