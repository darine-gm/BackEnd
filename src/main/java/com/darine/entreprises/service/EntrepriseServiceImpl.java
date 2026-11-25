package com.darine.entreprises.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.entities.Secteur;
import com.darine.entreprises.repos.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{

	//@Autowired
	EntrepriseRepository entrepriseRepository;
	
	
	
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
		super();
		this.entrepriseRepository = entrepriseRepository;
	}

	@Override
	public Entreprise saveEntreprise(Entreprise e) {
		
		return entrepriseRepository.save(e);
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		return entrepriseRepository.save(e);
	}

	@Override
	public void deleteEntreprise(Entreprise e) {
		entrepriseRepository.delete(e);
		
	}

	@Override
	public void deleteEntrepriseById(Long id) {
		entrepriseRepository.deleteById(id);
		
	}

	@Override
	public Entreprise getEntreprise(Long id) {
		return entrepriseRepository.findById(id).get();
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		return entrepriseRepository.findAll();
	}

	@Override
	public List<Entreprise> findByNom(String nom) {
		return entrepriseRepository.findByNom(nom);
	}

	@Override
	public List<Entreprise> findByNomContains(String nom) {
		
		return entrepriseRepository.findByNomContains(nom);
	}

	@Override
	public List<Entreprise> findByNomCha(String nom, Double cha) {
		
		return entrepriseRepository.findByNomCha(nom, cha);
	}

	@Override
	public List<Entreprise> findBySecteur(Secteur secteur) {
		
		return entrepriseRepository.findBySecteur(secteur);
	}

	@Override
	public List<Entreprise> findBySecteurIdSec(Long id) {
		
		return entrepriseRepository.findBySecteurIdSec(id);
	}

	@Override
	public List<Entreprise> findByOrderByNomAsc() {
		
		return entrepriseRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Entreprise> trierEntreprisesNomCha() {
		
		return entrepriseRepository.trierEntreprisesNomCha();
	}

}
