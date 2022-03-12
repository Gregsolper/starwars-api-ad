package com.gregorio.springboot.backend.starwars.models.entity;
// Generated 14 dic 2021 18:07:28 by Hibernate Tools 5.5.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class Films implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String title;
	@Column(name = "episode_id")
	private String episodeId;
	@Column(name = "opening_crawl")
	private String openingCrawl;
	private String director;
	private String producer;
	@Column(name = "release_date")
	private String releaseDate;
	private String created;
	private String edited;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "starships_films", joinColumns = @JoinColumn(name = "codigo_film"), inverseJoinColumns = @JoinColumn(name = "codigo_starship"))
	private Set<Starships> starshipses = new HashSet<Starships>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "films_planets", joinColumns = @JoinColumn(name = "codigo_film"), inverseJoinColumns = @JoinColumn(name = "codigo_planet"))
	private Set<Planets> planetses = new HashSet<Planets>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "films_people", joinColumns = @JoinColumn(name = "codigo_film"), inverseJoinColumns = @JoinColumn(name = "codigo_people"))
	private Set<People> peoples = new HashSet<People>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vehicles_films", joinColumns = @JoinColumn(name = "codigo_film"), inverseJoinColumns = @JoinColumn(name = "codigo_vehicle"))
	private Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);

	public Films() {
	}

	public Films(int codigo) {
		this.codigo = codigo;
	}

	public Films(int codigo, String title, String episodeId, String openingCrawl, String director, String producer,
			String releaseDate, String created, String edited, Set<Starships> starshipses, Set<Planets> planetses,
			Set<People> peoples, Set<Vehicles> vehicleses) {
		this.codigo = codigo;
		this.title = title;
		this.episodeId = episodeId;
		this.openingCrawl = openingCrawl;
		this.director = director;
		this.producer = producer;
		this.releaseDate = releaseDate;
		this.created = created;
		this.edited = edited;
		this.starshipses = starshipses;
		this.planetses = planetses;
		this.peoples = peoples;
		this.vehicleses = vehicleses;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEpisodeId() {
		return this.episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public String getOpeningCrawl() {
		return this.openingCrawl;
	}

	public void setOpeningCrawl(String openingCrawl) {
		this.openingCrawl = openingCrawl;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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

	public Set<Planets> getPlanetses() {
		return this.planetses;
	}

	public void setPlanetses(Set<Planets> planetses) {
		this.planetses = planetses;
	}

	public Set<People> getPeoples() {
		return this.peoples;
	}

	public void setPeoples(Set<People> peoples) {
		this.peoples = peoples;
	}

	public Set<Vehicles> getVehicleses() {
		return this.vehicleses;
	}

	public void setVehicleses(Set<Vehicles> vehicleses) {
		this.vehicleses = vehicleses;
	}

}
