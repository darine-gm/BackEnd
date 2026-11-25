package com.darine.entreprises.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.service.EntrepriseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/entreprises")
@CrossOrigin("*")
@AllArgsConstructor
public class EntrepriseRESTController {

	private final EntrepriseService entrepriseService;

	@GetMapping("/all")
	public List<Entreprise> getAllEntreprises() {
		return entrepriseService.getAllEntreprise();
	}

	@GetMapping("/{id}")
	public Entreprise getEntrepriseById(@PathVariable("id") Long id) {
		return entrepriseService.getEntreprise(id);
	}

	@PostMapping
	public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
		entreprise.setId(0L);
		return entrepriseService.saveEntreprise(entreprise);
	}

	@PutMapping
	public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseService.updateEntreprise(entreprise);
	}

	@DeleteMapping("/{id}")
	public void deleteEntreprise(@PathVariable("id") Long id) {
		entrepriseService.deleteEntrepriseById(id);
	}

	@GetMapping("/entrssec/{idSec}")
	public List<Entreprise> getEntreprisesBySecId(@PathVariable("idSec") Long idSec) {
		return entrepriseService.findBySecteurIdSec(idSec);
	}
}