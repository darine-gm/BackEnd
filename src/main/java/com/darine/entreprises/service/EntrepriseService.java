package com.darine.entreprises.service;

import java.util.List;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.entities.Secteur;

public interface EntrepriseService {
	Entreprise saveEntreprise(Entreprise e);
	Entreprise updateEntreprise(Entreprise e);
	void deleteEntreprise(Entreprise e);
	void deleteEntrepriseById(Long id);
	Entreprise getEntreprise(Long id);
	List<Entreprise> getAllEntreprise();
	List<Entreprise> findByNom(String nom);
	List<Entreprise> findByNomContains(String nom);
	List<Entreprise> findByNomCha (String nom, Double cha);
	List<Entreprise> findBySecteur (Secteur secteur);
	List<Entreprise> findBySecteurIdSec(Long id);
	List<Entreprise> findByOrderByNomAsc();
	List<Entreprise> trierEntreprisesNomCha();
	

}
