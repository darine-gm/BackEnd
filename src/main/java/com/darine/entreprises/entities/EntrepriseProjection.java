package com.darine.entreprises.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name= "nom", types = {Entreprise.class})
public interface EntrepriseProjection {
	public String getNom();
}
