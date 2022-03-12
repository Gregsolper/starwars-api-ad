package com.gregorio.springboot.backend.starwars.models.entity;
// Generated 14 dic 2021 18:07:28 by Hibernate Tools 5.5.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicles implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String name;
	private String model;
	@Column(name="vehicle_class")
	private String vehicleClass;
	private String manufacturer;
	private String length;
	@Column(name="cost_in_credits")
	private String costInCredits;
	private String crew;
	private String passengers;
	@Column(name="max_atmosphering_speed")
	private String maxAtmospheringSpeed;
	@Column(name="cargo_capacity")
	private String cargoCapacity;
	private String consumables;
	private String created;
	private String edited;
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="vehicles_people", joinColumns = {
			@JoinColumn (name="codigo_vehicle", nullable=false, updatable=false) },
		inverseJoinColumns= {
			@JoinColumn (name="codigo_people", nullable= false, updatable=false)	
		}
	)
	private Set<People> peoples = new HashSet<People>(0);
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="vehicles_films", joinColumns = {
			@JoinColumn (name="codigo_vehicle", nullable=false, updatable=false) },
		inverseJoinColumns= {
			@JoinColumn (name="codigo_film", nullable= false, updatable=false)	
		}
	)
	private Set<Films> filmses = new HashSet<Films>(0);

	public Vehicles() {
	}

	public Vehicles(int codigo) {
		this.codigo = codigo;
	}

	public Vehicles(int codigo, String name, String model, String vehicleClass, String manufacturer, String length,
			String costInCredits, String crew, String passengers, String maxAtmospheringSpeed, String cargoCapacity,
			String consumables, String created, String edited, Set<People> peoples, Set<Films> filmses) {
		this.codigo = codigo;
		this.name = name;
		this.model = model;
		this.vehicleClass = vehicleClass;
		this.manufacturer = manufacturer;
		this.length = length;
		this.costInCredits = costInCredits;
		this.crew = crew;
		this.passengers = passengers;
		this.maxAtmospheringSpeed = maxAtmospheringSpeed;
		this.cargoCapacity = cargoCapacity;
		this.consumables = consumables;
		this.created = created;
		this.edited = edited;
		this.peoples = peoples;
		this.filmses = filmses;
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

	public String getVehicleClass() {
		return this.vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCostInCredits() {
		return this.costInCredits;
	}

	public void setCostInCredits(String costInCredits) {
		this.costInCredits = costInCredits;
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

	public Set<People> getPeoples() {
		return this.peoples;
	}

	public void setPeoples(Set<People> peoples) {
		this.peoples = peoples;
	}

	public Set<Films> getFilmses() {
		return this.filmses;
	}

	public void setFilmses(Set<Films> filmses) {
		this.filmses = filmses;
	}

}
