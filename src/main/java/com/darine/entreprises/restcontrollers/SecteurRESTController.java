package com.darine.entreprises.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darine.entreprises.entities.Secteur;
import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.repos.SecteurRepository;
import com.darine.entreprises.service.EntrepriseService;

@RestController
@RequestMapping("/api/sec")
@CrossOrigin("*")
public class SecteurRESTController {
	
	@Autowired
	SecteurRepository secteurRepository;

	@Autowired
	EntrepriseService entrepriseService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Secteur> getAllSecteur()
	{
		return secteurRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Secteur getSecteurById(@PathVariable("id") Long id) {
		return secteurRepository.findById(id).get();
	}

	@PostMapping
	public Secteur createSecteur(@RequestBody Secteur secteur) {
		return secteurRepository.save(secteur);
	}

	@PutMapping("/{id}")
	public Secteur updateSecteur(@PathVariable("id") Long id, @RequestBody Secteur secteur) {
		secteur.setIdSec(id);
		return secteurRepository.save(secteur);
	}

	@RequestMapping(value="/entrsByName/{nom}",method = RequestMethod.GET)
	public List<Entreprise> findByNomContains(@PathVariable("nom") String nom) {
		return entrepriseService.findByNomContains(nom);
	}

}
