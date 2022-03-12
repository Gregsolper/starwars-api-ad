package com.gregorio.springboot.backend.starwars.models.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.gregorio.springboot.backend.starwars.models.dto.PeopleDTO;

@Entity
@Table (name="people")
//@JsonIgnoreProperties (value= {"planets","filmses","vehicles","starshipses","specieses"})
public class People implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeworld")  // peoples
	private Planets planets;
	@NotEmpty
	@Size(min=2,max=25)
	private String name;
	
	@Column(name="birth_year")
	private String birthYear;
	@Column(name="eye_color")
	private String eyeColor;
	private String gender;
	@Column(name="hair_color")
	private String hairColor;
	private String height;
	private String mass;
	@Column(name="skin_color")
	private String skinColor;
	private String created;
	private String edited;
	
	
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="starships_people", joinColumns = {
				@JoinColumn (name="codigo_people", nullable=false, updatable=false) },
			inverseJoinColumns= {
				@JoinColumn (name="codigo_starship", nullable= false, updatable=false)	
			}
	)
	private Set<Starships> starshipses = new HashSet<Starships>(0);
	
	
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="species_people", joinColumns = {
				@JoinColumn (name="codigo_people", nullable=false, updatable=false) },
			inverseJoinColumns= {
				@JoinColumn (name="codigo_specie", nullable= false, updatable=false)	
			}
	)
	private Set<Species> specieses = new HashSet<Species>(0);
	
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="vehicles_people", joinColumns = {
			@JoinColumn (name="codigo_people", nullable=false, updatable=false) },
		inverseJoinColumns= {
			@JoinColumn (name="codigo_vehicle", nullable= false, updatable=false)	
		}
	)
	private Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);
	
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="films_people", joinColumns = {
			@JoinColumn (name="codigo_people", nullable=false, updatable=false) },
		inverseJoinColumns= {
			@JoinColumn (name="codigo_film", nullable= false, updatable=false)	
		}
	)
	private Set<Films> filmses = new HashSet<Films>(0);
	
	
	public People() {
	}

	public People(int codigo) {
		this.codigo = codigo;
	}

	public People(int codigo, Planets planets, String name, String birthYear, String eyeColor, String gender,
			String hairColor, String height, String mass, String skinColor, String created, String edited,
			Set<Starships> starshipses, Set<Species> specieses, Set<Vehicles> vehicleses, Set<Films> filmses) {
		this.codigo = codigo;
		this.planets = planets;
		this.name = name;
		this.birthYear = birthYear;
		this.eyeColor = eyeColor;
		this.gender = gender;
		this.hairColor = hairColor;
		this.height = height;
		this.mass = mass;
		this.skinColor = skinColor;
		this.created = created;
		this.edited = edited;
		this.starshipses = starshipses;
		this.specieses = specieses;
		this.vehicleses = vehicleses;
		this.filmses = filmses;
	}
	
	public People(@Valid PeopleDTO peopleDto) {
		this.codigo= peopleDto.getCodigo();
		this.name = peopleDto.getName();
		this.birthYear=peopleDto.getBirthYear();
		this.eyeColor=peopleDto.getEyeColor();
		this.gender=peopleDto.getGender();
		this.hairColor=peopleDto.getHairColor();
		this.height=peopleDto.getHeight();
		this.mass=peopleDto.getMass();
		this.skinColor=peopleDto.getSkinColor();
		this.created=peopleDto.getCreated();
		this.edited=peopleDto.getEdited();
	}

	public void copiar (People origen) {
		this.planets = origen.getPlanets();
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
		this.starshipses=origen.getStarshipses();
		this.specieses=origen.getSpecieses();
		this.vehicleses= origen.getVehicleses();
		this.filmses = origen.getFilmses();
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Planets getPlanets() {
		return this.planets;
	}

	public void setPlanets(Planets planets) {
		this.planets = planets;
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

	public Set<Starships> getStarshipses() {
		return this.starshipses;
	}

	public void setStarshipses(Set<Starships> starshipses) {
		this.starshipses = starshipses;
	}

	public Set<Species> getSpecieses() {
		return this.specieses;
	}

	public void setSpecieses(Set<Species> specieses) {
		this.specieses = specieses;
	}

	public Set<Vehicles> getVehicleses() {
		return this.vehicleses;
	}

	public void setVehicleses(Set<Vehicles> vehicleses) {
		this.vehicleses = vehicleses;
	}
	
	public Set<Films> getFilmses() {
		return this.filmses;
	}

	public void setFilmses(Set<Films> filmses) {
		this.filmses = filmses;
	}

}
