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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@NamedQueries({
@NamedQuery(name = "Planets.findAll",
query = "SELECT p FROM Planets p"),
@NamedQuery(name = "Planets.withoutPeople",
query = "SELECT p FROM Planets p WHERE p.peoples is empty")
})
@Table(name = "planets")
public class Planets implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String name;
	private String diameter;
	@Column(name = "rotation_period")
	private String rotationPeriod;
	@Column(name = "orbital_period")
	private String orbitalPeriod;
	private String gravity;
	private String population;
	private String climate;
	private String terrain;
	@Column(name = "surface_water")
	private String surfaceWater;
	private String created;
	private String edited;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planets")
	private Set<Species> specieses = new HashSet<Species>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planets")
	private Set<People> peoples = new HashSet<People>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "films_planets", joinColumns = {
			@JoinColumn(name = "codigo_planet", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "codigo_film", nullable = false, updatable = false) })
	private Set<Films> filmses = new HashSet<Films>(0);

	public Planets() {
	}

	public Planets(int codigo) {
		this.codigo = codigo;
	}

	public Planets(int codigo, String name, String diameter, String rotationPeriod, String orbitalPeriod,
			String gravity, String population, String climate, String terrain, String surfaceWater, String created,
			String edited, Set<Species> specieses, Set<People> peoples, Set<Films> filmses) {
		this.codigo = codigo;
		this.name = name;
		this.diameter = diameter;
		this.rotationPeriod = rotationPeriod;
		this.orbitalPeriod = orbitalPeriod;
		this.gravity = gravity;
		this.population = population;
		this.climate = climate;
		this.terrain = terrain;
		this.surfaceWater = surfaceWater;
		this.created = created;
		this.edited = edited;
		this.specieses = specieses;
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

	public String getDiameter() {
		return this.diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getRotationPeriod() {
		return this.rotationPeriod;
	}

	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

	public String getOrbitalPeriod() {
		return this.orbitalPeriod;
	}

	public void setOrbitalPeriod(String orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public String getGravity() {
		return this.gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getClimate() {
		return this.climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return this.terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getSurfaceWater() {
		return this.surfaceWater;
	}

	public void setSurfaceWater(String surfaceWater) {
		this.surfaceWater = surfaceWater;
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

	public Set<Species> getSpecieses() {
		return this.specieses;
	}

	public void setSpecieses(Set<Species> specieses) {
		this.specieses = specieses;
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
