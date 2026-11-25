package com.darine.entreprises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.darine.entreprises.entities.Entreprise;
import com.darine.entreprises.entities.Secteur;

@SpringBootApplication
public class EntreprisesApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EntreprisesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		repositoryRestConfiguration.exposeIdsFor(Entreprise.class, Secteur.class);
	}

}
