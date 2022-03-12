package com.gregorio.springboot.backend.starwars.models.dto;
import java.util.HashSet;
import java.util.Set;

import com.gregorio.springboot.backend.starwars.models.entity.People;

public class PeopleDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int codigo;
	private int homeWorld;
	private String name;
	private String birthYear;
	private String eyeColor;
	private String gender;
	private String hairColor;
	private String height;
	private String mass;
	private String skinColor;
	private String created;
	private String edited;
	private Set<Integer> starshipses = new HashSet<Integer>(0);
	private Set<Integer> specieses = new HashSet<Integer>(0);
	private Set<Integer> vehicleses = new HashSet<Integer>(0);
	private Set<Integer> filmses = new HashSet<Integer>(0);
	
	
	public PeopleDTO() {
	}

	public PeopleDTO (int codigo) {
		this.codigo = codigo;
	}
	

	public PeopleDTO(People origen) {
		this.copiar(origen);
	}

	public void copiar (People origen) {
		this.codigo= origen.getCodigo();
		if (origen.getPlanets()==null)
			this.homeWorld=-1;
		else 
			this.homeWorld = origen.getPlanets().getCodigo();
		this.name = origen.getName();
		this.birthYear=origen.getBirthYear();
		this.eyeColor=origen.getEyeColor();
		this.gender=origen.getGender();
		this.hairColor=origen.getHairColor();
		this.height=origen.getHeight();
		this.mass=origen.getMass();
		this.skinColor=origen.getSkinColor();
		this.created=origen.getCreated();
		this.edited=origen.getEdited();
		origen.getStarshipses().stream().forEach(s->this.starshipses.add(s.getCodigo()));
		origen.getSpecieses().stream().forEach(s->this.specieses.add(s.getCodigo()));
		origen.getVehicleses().stream().forEach(v->this.vehicleses.add(v.getCodigo()));
		origen.getFilmses().stream().forEach(f->this.filmses.add(f.getCodigo()));
		
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getEyeColor() {
		return this.eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHairColor() {
		return this.hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return this.mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getSkinColor() {
		return this.skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return this.edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public Set<Integer> getStarshipses() {
		return this.starshipses;
	}

	public void setStarshipses(Set<Integer> starshipses) {
		this.starshipses = starshipses;
	}


	public Set<Integer> getSpecieses() {
		return specieses;
	}

	public void setSpecieses(Set<Integer> specieses) {
		this.specieses = specieses;
	}

	public Set<Integer> getVehicleses() {
		return vehicleses;
	}

	public void setVehicleses(Set<Integer> vehicleses) {
		this.vehicleses = vehicleses;
	}

	public Set<Integer> getFilmses() {
		return filmses;
	}

	public void setFilmses(Set<Integer> filmses) {
		this.filmses = filmses;
	}

	public int getHomeWorld() {
		return homeWorld;
	}

	public void setHomeWorld(int homeWorld) {
		this.homeWorld = homeWorld;
	}

}
