package com.darine.entreprises.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.entities.Secteur;

@RepositoryRestResource(path = "rest")

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	List<Entreprise> findByNom(String nom);
	List<Entreprise> findByNomContains(String nom);
	
	/*@Query("select e from Entreprise e where e.nom like %?1 and e.cha> ?2")
	List<Entreprise> findByNomCha (String nom, Double cha);*/
	
	@Query("select e from Entreprise e where e.nom like %:nom% and e.cha >= :cha")
	List<Entreprise> findByNomCha (@Param("nom")String nom,@Param("cha") Double cha); 
	
	@Query("select e from Entreprise e where e.secteur=?1")
	List<Entreprise> findBySecteur (Secteur secteur);
	
	List<Entreprise> findBySecteurIdSec(Long id);
	
	List<Entreprise> findByOrderByNomAsc();
	
	
	@Query("select e from Entreprise e order by e.nom ASC, e.cha DESC")
	List<Entreprise> trierEntreprisesNomCha();
	
	
	
}
