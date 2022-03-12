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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="species")
public class Species implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeworld")
	private Planets planets;
	private String name;
	private String classification;
	private String designation;
	@Column(name="average_height")
	private String averageHeight;
	@Column(name="average_lifespan")
	private String averageLifespan;
	@Column(name="eye_colors")
	private String eyeColors;
	@Column(name="hair_colors")
	private String hairColors;
	@Column(name="skin_colors")
	private String skinColors;
	private String language;
	private String created;
	private String edited;
	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable (name="species_people", joinColumns = {
				@JoinColumn (name="codigo_specie", nullable=false, updatable=false) },
			inverseJoinColumns= {
				@JoinColumn (name="codigo_people", nullable= false, updatable=false)	
			}
	)
	private Set<People> peoples = new HashSet<People>(0);

	public Species() {
	}

	public Species(int codigo) {
		this.codigo = codigo;
	}

	public Species(int codigo, Planets planets, String name, String classification, String designation,
			String averageHeight, String averageLifespan, String eyeColors, String hairColors, String skinColors,
			String language, String created, String edited, Set<People> peoples) {
		this.codigo = codigo;
		this.planets = planets;
		this.name = name;
		this.classification = classification;
		this.designation = designation;
		this.averageHeight = averageHeight;
		this.averageLifespan = averageLifespan;
		this.eyeColors = eyeColors;
		this.hairColors = hairColors;
		this.skinColors = skinColors;
		this.language = language;
		this.created = created;
		this.edited = edited;
		this.peoples = peoples;
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

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAverageHeight() {
		return this.averageHeight;
	}

	public void setAverageHeight(String averageHeight) {
		this.averageHeight = averageHeight;
	}

	public String getAverageLifespan() {
		return this.averageLifespan;
	}

	public void setAverageLifespan(String averageLifespan) {
		this.averageLifespan = averageLifespan;
	}

	public String getEyeColors() {
		return this.eyeColors;
	}

	public void setEyeColors(String eyeColors) {
		this.eyeColors = eyeColors;
	}

	public String getHairColors() {
		return this.hairColors;
	}

	public void setHairColors(String hairColors) {
		this.hairColors = hairColors;
	}

	public String getSkinColors() {
		return this.skinColors;
	}

	public void setSkinColors(String skinColors) {
		this.skinColors = skinColors;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

}
