package com.example.bartspetitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BartspetitionsApplication {

	//private static final Logger log = LoggerFactory.getLogger(BartspetitionsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BartspetitionsApplication.class, args);
	}



	@Bean
	public CommandLineRunner demo(PetitionRepository repository) {
		return (args) -> {
			// save a few Petitions
			repository.save(new Petition("Stop Whaling - Help Protect the Ocean", "Due to modern" +
					" fishing methods we are catching fish at a rate that is unsustainable. 34% of species are currently" +
					" below sustainable levels and nearly 60% are at, or close to their maximum sustainable yield." +
					" We have to address our global fisheries management processes and the devastating impact of many" +
					" existing fishing practices."));
			repository.save(new Petition("Four Day Week Ireland", "As global leaders in reduced" +
					" work time, we are passionate about helping businesses, individuals, and governments work towards" +
					" a future where productivity is prioritised over working hours, and work/life balance can be" +
					" improved without sacrificing business results. We have worked with dozens of organisations" +
					" across the world to implement shorter work weeks with outstanding results. Now we want to help" +
					" you get there too."));
			repository.save(new Petition("Ending Nuclear Tests", "Nuclear testing is a key step" +
					" in the development of nuclear weapons. By ending this, the CTBT curbs all nuclear arms" +
					" proliferation, be it the development of nuclear weapons by countries that do not currently have" +
					" them, upgrades to current nuclear arsenals or the creation of new, more advanced generations of" +
					" nuclear weapons."));
/*
			// fetch all petitions
			log.info("Petitions found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(petition -> {
				log.info(petition.toString());
			});
			log.info("");

			// fetch an individual petition by ID
			Petition petition = repository.findById(1L);
			log.info("Petition found with findById(1L):");
			log.info("--------------------------------");
			log.info(petition.toString());
			log.info("");

			// fetch petition by title
			log.info("Petition found with findByPetitionTitleContaining('T'):");
			log.info("--------------------------------------------");
			repository.findByPetitionTitleContaining("T").forEach(titleFound -> {
				log.info(titleFound.toString());
			});
			log.info("");*/
		};
	}
}