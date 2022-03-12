package com.gregorio.springboot.backend.starwars.models.dto;

import com.gregorio.springboot.backend.starwars.models.entity.Films;
import com.gregorio.springboot.backend.starwars.models.entity.People;
import com.gregorio.springboot.backend.starwars.models.entity.Planets;
import com.gregorio.springboot.backend.starwars.models.entity.Species;
import com.gregorio.springboot.backend.starwars.models.entity.Starships;
import com.gregorio.springboot.backend.starwars.models.entity.Vehicles;

public class CatalogoDTO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String name;
	
	/**
	 * @param codigo
	 * @param name
	 */
	public CatalogoDTO(int codigo, String name) {
		super();
		this.codigo = codigo;
		this.name = name;
	}
	public CatalogoDTO(Planets p) {
		this.codigo = p.getCodigo();
		this.name =p.getName();
	}
	public CatalogoDTO(People p) {
		this.codigo = p.getCodigo();
		this.name =p.getName();
	}
	public CatalogoDTO(Starships p)	{
		this.codigo = p.getCodigo();
		this.name =p.getName();	
	}
	public CatalogoDTO(Films p) {
		this.codigo = p.getCodigo();
		this.name =p.getTitle();
	}
	public CatalogoDTO(Species p) {
		this.codigo = p.getCodigo();
		this.name =p.getName();
	}
	public CatalogoDTO(Vehicles p) {
		this.codigo = p.getCodigo();
		this.name =p.getName();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
