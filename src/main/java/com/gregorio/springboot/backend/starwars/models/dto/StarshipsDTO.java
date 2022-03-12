package com.gregorio.springboot.backend.starwars.models.dto;
// Generated 14 dic 2021 18:07:28 by Hibernate Tools 5.5.7.Final

import java.util.HashSet;
import java.util.Set;

import com.gregorio.springboot.backend.starwars.models.entity.Starships;


public class StarshipsDTO implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int codigo;
	private String name;
	private String model;
	private String starshipClass;
	private String manufacturer;
	private String costInCredits;
	private String length;
	private String crew;
	private String passengers;
	private String maxAtmospheringSpeed;
	private String hyperdriveRating;
	private String mglt;
	private String cargoCapacity;
	private String consumables;
	private String created;
	private String edited;
	private Set<Integer> filmses = new HashSet<Integer>(0);
	private Set<Integer> peoples = new HashSet<Integer>(0);

	public StarshipsDTO() {
	}

	public StarshipsDTO(int codigo) {
		this.codigo = codigo;
	}


	public StarshipsDTO(Starships p) {
		this.copiar(p);
	}

	public void copiar (Starships origen) {
		 this.codigo = origen.getCodigo();
		 this.name = origen.getName();
		 this.model = origen.getModel();
		 this.starshipClass = origen.getStarshipClass();
		 this.manufacturer = origen.getManufacturer();
		 this.costInCredits = origen.getCostInCredits();
		 this.length = origen.getLength();
		 this.crew = origen.getCrew();
		 this.passengers= origen.getPassengers();
		 this.maxAtmospheringSpeed = origen.getMaxAtmospheringSpeed();
		 this.hyperdriveRating = origen.getHyperdriveRating();
		 this.mglt=  origen.getMglt();
		 this.cargoCapacity = origen.getCargoCapacity();
		 this.consumables= origen.getConsumables();
		 this.created=origen.getCreated();
		 this.edited=origen.getEdited();
		 origen.getFilmses().forEach(f->this.filmses.add(f.getCodigo()));
		 origen.getPeoples().forEach(p->this.peoples.add(p.getCodigo()));
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStarshipClass() {
		return this.starshipClass;
	}

	public void setStarshipClass(String starshipClass) {
		this.starshipClass = starshipClass;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCostInCredits() {
		return this.costInCredits;
	}

	public void setCostInCredits(String costInCredits) {
		this.costInCredits = costInCredits;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCrew() {
		return this.crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return this.passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getMaxAtmospheringSpeed() {
		return this.maxAtmospheringSpeed;
	}

	public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
		this.maxAtmospheringSpeed = maxAtmospheringSpeed;
	}

	public String getHyperdriveRating() {
		return this.hyperdriveRating;
	}

	public void setHyperdriveRating(String hyperdriveRating) {
		this.hyperdriveRating = hyperdriveRating;
	}

	public String getMglt() {
		return this.mglt;
	}

	public void setMglt(String mglt) {
		this.mglt = mglt;
	}

	public String getCargoCapacity() {
		return this.cargoCapacity;
	}

	public void setCargoCapacity(String cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public String getConsumables() {
		return this.consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public Set<Integer> getFilmses() {
		return filmses;
	}

	public void setFilmses(Set<Integer> filmses) {
		this.filmses = filmses;
	}

	public Set<Integer> getPeoples() {
		return peoples;
	}

	public void setPeoples(Set<Integer> peoples) {
		this.peoples = peoples;
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



}
