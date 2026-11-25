package com.darine.entreprises;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.entities.Secteur;
import com.darine.entreprises.repos.EntrepriseRepository;

@SpringBootTest
class EntreprisesApplicationTests {

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	 
	@Test
	public void testCreateEntreprise() {
		
		Entreprise entr = new Entreprise("lenovo","Tunis",234.200,	new Date());
		entrepriseRepository.save(entr);
	}
	
	@Test
	public void testFindEntreprise()
	{
		Entreprise e = entrepriseRepository.save(
				new Entreprise("test-find", "Tunis", 500.0, new Date()));
		System.out.println(e);
	}
	
	@Test
	public void testUpdateEntreprise()
	{
		Entreprise e = entrepriseRepository.save(
				new Entreprise("test-update", "Tunis", 1000.0, new Date()));
		e.setCha(2000.0);
		entrepriseRepository.save(e);
		System.out.println(e);
	}
	
	@Test
	public void testDeleteEntreprise()
	{
		Entreprise e = entrepriseRepository.save(
				new Entreprise("test-delete", "Tunis", 500.0, new Date()));
		entrepriseRepository.deleteById(e.getId());

		if (entrepriseRepository.findById(e.getId()).isPresent()) {
			throw new AssertionError("L'entreprise n'a pas été supprimée");
		}
	}
	
	@Test
	public void testFindAllEntreprise  ()
	{
		List<Entreprise> entrs=entrepriseRepository.findAll();
		for(Entreprise e:entrs)
			System.out.println(e);
	}
	
	@Test
	public void testFindEntrepriseByNom()
	{
		List<Entreprise> entrs=entrepriseRepository.findByNom("lenovo");
		for(Entreprise e:entrs)
			System.out.println(e);
	}
	
	@Test
	public void testFindEntrepriseByNomContains()
	{
		List<Entreprise> entrs=entrepriseRepository.findByNomContains("e");
		for(Entreprise e:entrs)
			System.out.println(e);
	}
	
	@Test
	public void testfindByNomCha()
	{
		List<Entreprise> entrs=entrepriseRepository.findByNomCha("lenovo",1000.0);
		for(Entreprise e:entrs) {
			System.out.println(e);
		}
	}
	@Test 
	public void testfindBySecteur()
	{
		Secteur sec = new Secteur();
		sec.setIdSec(1L);
		
		List<Entreprise> entrs = entrepriseRepository.findBySecteur(sec);
		for (Entreprise e : entrs) {
			System.out.println(e);
		}
	}
	
	@Test
	public void findBySecteurIdSec()
	{
		List<Entreprise> entrs = entrepriseRepository.findBySecteurIdSec(1L);
		for (Entreprise e : entrs) {
			System.out.println(e);
		}
		
		
	}
	
	@Test
	public void findByOrderByNomAsc()
	{
		List<Entreprise> entrs = entrepriseRepository.findByOrderByNomAsc();
		for (Entreprise e : entrs) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void testTrierEntreprisesNomCha()
	{
		List<Entreprise> entrs = entrepriseRepository.trierEntreprisesNomCha();
		for (Entreprise e : entrs) {
			System.out.println(e);
		}}
	
	
	
	
	
}