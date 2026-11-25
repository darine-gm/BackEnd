package com.darine.entreprises.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSec;
	
	private String nomSec;
	private String descriptionSec;
	
	
	@OneToMany(mappedBy="secteur")
	@JsonIgnore
	private List<Entreprise> entreprises;
	
	public Long getIdSec() {
		return idSec;
	}
	public void setIdSec(Long idSec) {
		this.idSec = idSec;
	}
	
	public String getNomSec() {
		return nomSec;
	}
	public void setNomSec(String nomSec) {
		this.nomSec = nomSec;
	}
	public String getDescriptionSec() {
		return descriptionSec;
	}
	public void setDescriptionSec(String descriptionSec) {
		this.descriptionSec = descriptionSec;
	}
	public List<Entreprise> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	
	
}
