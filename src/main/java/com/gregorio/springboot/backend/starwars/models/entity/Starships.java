package com.gregorio.springboot.backend.starwars.models.entity;
// Generated 14 dic 2021 18:07:28 by Hibernate Tools 5.5.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.gregorio.springboot.backend.starwars.models.dto.StarshipsDTO;

import javax.persistence.JoinColumn;

@Entity
@Table (name="starships")
public class Starships implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	@NotEmpty
	@Size(min=2,max=25)
	private String name;
	private String model;
	@Column(name="starship_class")
	private String starshipClass;
	private String manufacturer;
	@Column(name="cost_in_credits")
	private String costInCredits;
	private String length;
	private String crew;
	private String passengers;
	@Column (name="max_atmosphering_speed")
	private String maxAtmospheringSpeed;
	@Column(name="hyperdrive_rating")
	private String hyperdriveRating;
	private String mglt;
	@Column (name="cargo_capacity")
	private String cargoCapacity;
	private String consumables;
	private String created;
	private String edited;
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="starships_films", joinColumns = {
				@JoinColumn (name="codigo_starship", nullable=false, updatable=false) },
			inverseJoinColumns= {
				@JoinColumn (name="codigo_film", nullable= false, updatable=false)	
			}
	)
	private Set<Films> filmses = new HashSet<Films>(0);
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="starships_people", joinColumns = {
				@JoinColumn (name="codigo_starship", nullable=false, updatable=false) },
			inverseJoinColumns= {
				@JoinColumn (name="codigo_people", nullable= false, updatable=false)	
			}
	)
	private Set<People> peoples = new HashSet<People>(0);

	public Starships() {
	}

	public Starships(int codigo) {
		this.codigo = codigo;
	}

	public Starships(int codigo, String name, String model, String starshipClass, String manufacturer,
			String costInCredits, String length, String crew, String passengers, String maxAtmospheringSpeed,
			String hyperdriveRating, String mglt, String cargoCapacity, String consumables, String created,
			String edited, Set<Films> filmses, Set<People> peoples) {
		this.codigo = codigo;
		this.name = name;
		this.model = model;
		this.starshipClass = starshipClass;
		this.manufacturer = manufacturer;
		this.costInCredits = costInCredits;
		this.length = length;
		this.crew = crew;
		this.passengers = passengers;
		this.maxAtmospheringSpeed = maxAtmospheringSpeed;
		this.hyperdriveRating = hyperdriveRating;
		this.mglt = mglt;
		this.cargoCapacity = cargoCapacity;
		this.consumables = consumables;
		this.created = created;
		this.edited = edited;
		this.filmses = filmses;
		this.peoples = peoples;
	}

	public Starships(StarshipsDTO origen) {
		this.codigo = origen.getCodigo();
		this.name = origen.getName();
		this.model = origen.getModel();
		this.starshipClass = origen.getStarshipClass();
		this.manufacturer = origen.getManufacturer();
		this.costInCredits = origen.getCostInCredits();
		this.length = origen.getLength();
		this.crew = origen.getCrew();
		this.passengers = origen.getPassengers();
		this.maxAtmospheringSpeed = origen.getMaxAtmospheringSpeed();
		this.hyperdriveRating = origen.getHyperdriveRating();
		this.mglt = origen.getMglt();
		this.cargoCapacity = origen.getCargoCapacity();
		this.consumables = origen.getConsumables();
		this.created = origen.getCreated();
		this.edited = origen.getEdited();
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

	public Set<Films> getFilmses() {
		return this.filmses;
	}

	public void setFilmses(Set<Films> filmses) {
		this.filmses = filmses;
	}

	public Set<People> getPeoples() {
		return this.peoples;
	}

	public void setPeoples(Set<People> peoples) {
		this.peoples = peoples;
	}

}
