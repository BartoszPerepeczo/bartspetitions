package com.example.bartspetitions;

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
	public CommandLineRunner demo(PetitionRepository petitionRepository, PersonRepository personRepository) {
		return (args) -> {
			// save a few Users
			personRepository.save(new Person("Jack", "jack@gmail.com"));
			personRepository.save(new Person("Jill", "j97@hotmail.com"));
			personRepository.save(new Person("Padraig", "P.Mullen17@universityofgallwaygmail.com"));
			personRepository.save(new Person("Steve", "stevetheboss@gmail.com"));

			// save a few Petitions
			petitionRepository.save(new Petition(1L,"Save the Whales", "The effects of nearly a century of commercial whaling have had long-lasting effects. Luckily, a 1986 ban made commercial whaling illegal worldwide. But there is still work to be done to save the whales.","A few countries — namely Japan, Norway, and Iceland — continue to ignore a 1986 moratorium on commercial whaling. Every year, these three countries kill thousands of whales, selling their meat on an illegal black market.\n" +
					"\n" +
					"For more than 40 years we’ve been at the forefront of this evolving fight to end this needless slaughter of one the most magnificent creatures on the planet.\n" +
					"\n" +
					"How We Can Save the Whales\n" +
					"The environmental community must continue to fight on all levels to end the slaughter. Here’s what we’re doing:\n" +
					"\n" +
					"Hold our government accountable for closing the loopholes in international agreements and ending all commercial whaling.\n" +
					"Persuading many of the countries currently voting with Japan to overturn the commercial whaling moratorium to reconsider their approach and instead vote to protect whales.\n" +
					"Continue exposing Japan’s black-market whale meat trade — which is both unpopular and uneconomical — to create a public discussion in the Japanese media about the future of whaling.\n" +
					"Background on Whaling\n" +
					"In 1986, a moratorium was put in place to halt commercial whaling — completely separate from subsistence whaling or cultural traditions — and help dwindling whale populations recover.\n" +
					"\n" +
					"But 25 years later, the fight to end commercial whaling once and for all is not over. Japan, Iceland, and Norway all continue to hunt whales while the authorities turn a blind eye to the slaughter.\n" +
					"\n" +
					"Whaling was rampant for so long that many species may never recover. In the United States, the North Atlantic right whale has a lonely population of about 350.\n" +
					"\n" +
					"The blue whales of the Antarctic are at less than 1 percent of their original abundance. West Pacific grey whale populations are the most endangered of the world’s great whales, hovering on the edge of extinction with just over 100 remaining.\n" +
					"\n" +
					"Endangered whales have many obstacles to face today — global warming, pollution, ocean acidification, noise and ship strikes, just to name a few. Overfishing threatens their food supply and hundreds of whales are entangled in fishing gear every year.\n" +
					"\n" +
					"Calling All Whale Defenders\n" +
					"We’re not backing down in our efforts to protect whales until this shameful and unnecessary slaughter has been stopped and whales can once again roam the seas in freedom. Are you with us?"));
			petitionRepository.save(new Petition(2L,"Four Day Week Ireland", "As global leaders in reduced" +
					" work time, we are passionate about helping businesses, individuals, and governments work towards" +
					" a future where productivity is prioritised over working hours, and work/life balance can be" +
					" improved without sacrificing business results. We have worked with dozens of organisations" +
					" across the world to implement shorter work weeks with outstanding results. Now we want to help" +
					" you get there too.",""));
			petitionRepository.save(new Petition(3L,"Ending Nuclear Tests", "Nuclear testing is a key step" +
					" in the development of nuclear weapons. By ending this, the CTBT curbs all nuclear arms" +
					" proliferation, be it the development of nuclear weapons by countries that do not currently have" +
					" them, upgrades to current nuclear arsenals or the creation of new, more advanced generations of" +
					" nuclear weapons.",""));
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