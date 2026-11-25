package com.darine.entreprises.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.darine.entreprises.entities.Secteur;

@RepositoryRestResource(path = "secteur")
@CrossOrigin("http://localhost:4200/")
public interface SecteurRepository extends JpaRepository<Secteur, Long>{

}
