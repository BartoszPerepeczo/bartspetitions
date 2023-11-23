package com.example.bartspetitions;

import com.example.bartspetitions.model.PetitionPerson;
import com.example.bartspetitions.repository.PersonRepository;
import com.example.bartspetitions.repository.PetitionPersonRepository;
import com.example.bartspetitions.repository.PetitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BartspetitionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BartspetitionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PetitionRepository petition, PersonRepository person, PetitionPersonRepository petitionPersonRepository) {
		return (args) -> {
			// save a few Users
			person.save(new com.example.bartspetitions.model.Person("Jack", "jack@gmail.com"));
			person.save(new com.example.bartspetitions.model.Person("Jill", "j97@hotmail.com"));
			person.save(new com.example.bartspetitions.model.Person("Padraig", "P.Mullen17@universityofgallway.ie"));
			person.save(new com.example.bartspetitions.model.Person("Steve", "stevetheboss@gmail.com"));

			// save a few Petitions
			petition.save(new com.example.bartspetitions.model.Petition(1L,"Save the Whales",
					"The effects of nearly a century of commercial whaling have had long-lasting effects. Luckily, a 1986 ban made commercial whaling illegal worldwide. But there is still work to be done to save the whales.",
					"A few countries — namely Japan, Norway, and Iceland — continue to ignore a 1986 moratorium on commercial whaling. Every year, these three countries kill thousands of whales, selling their meat on an illegal black market. " +
					"For more than 40 years we’ve been at the forefront of this evolving fight to end this needless slaughter of one the most magnificent creatures on the planet. " +
					"How We Can Save the Whales " +
					"The environmental community must continue to fight on all levels to end the slaughter. Here’s what we’re doing: " +
					"Hold our government accountable for closing the loopholes in international agreements and ending all commercial whaling. " +
					"Persuading many of the countries currently voting with Japan to overturn the commercial whaling moratorium to reconsider their approach and instead vote to protect whales. " +
					"Continue exposing Japan’s black-market whale meat trade — which is both unpopular and uneconomical — to create a public discussion in the Japanese media about the future of whaling. " +
					"Background on Whaling " +
					"In 1986, a moratorium was put in place to halt commercial whaling — completely separate from subsistence whaling or cultural traditions — and help dwindling whale populations recover. " +
					"But 25 years later, the fight to end commercial whaling once and for all is not over. Japan, Iceland, and Norway all continue to hunt whales while the authorities turn a blind eye to the slaughter. " +
					"Whaling was rampant for so long that many species may never recover. In the United States, the North Atlantic right whale has a lonely population of about 350. " +
					"The blue whales of the Antarctic are at less than 1 percent of their original abundance. West Pacific grey whale populations are the most endangered of the world’s great whales, hovering on the edge of extinction with just over 100 remaining. " +
					"Endangered whales have many obstacles to face today — global warming, pollution, ocean acidification, noise and ship strikes, just to name a few. Overfishing threatens their food supply and hundreds of whales are entangled in fishing gear every year. " +
					"Calling All Whale Defenders " +
					"We’re not backing down in our efforts to protect whales until this shameful and unnecessary slaughter has been stopped and whales can once again roam the seas in freedom. Are you with us?"));
			petition.save(new com.example.bartspetitions.model.Petition(2L,"Four Day Week Ireland",
					"Four Day Week Ireland is a campaign advocating for a gradual, steady, managed transition to a shorter working week for all workers, in the private and public sectors.",
					"PRODUCTIVITY" +
							"Shift your business away from measuring productivity based on hours worked and towards measuring based on results. A wide range of organisations in a variety of industries all over the world have been extremely satisfied with their companies’ productivity when piloting a 4 day week, with 91% opting to continue once their trials conclude." +
							"PERFORMANCE" +
							"Enhance your business performance while improving your bottom line. Companies rated their overall experience with the 4 day week trials an 8.5/10, with great satisfaction in performance observed. Revenue rose an average of 35% over the course of the pilot, when compared to a similar period from previous years." +
							"RECRUITMENT" +
							"Give your business a competitive edge when it comes to attracting top talent and help retain your best employees by cutting down on unplanned attrition. Results show that workers on a 4 day week are 57% less likely to quit their jobs." +
							"ENGAGEMENT" +
							"Create a more energized, efficient, empowered and motivated workforce that’s focused on organizational priorities, delivering outputs and achieving key targets. 'Employees report feeling more productive and better able to do their jobs, with 55% reporting an increase in their ability at work on a 4 day week." +
							"WELL-BEING" +
							"Improve your team’s work-life balance and deliver transformational benefits to their daily lives. A remarkable 73% of workers on a 4 day week observe greater satisfaction with their time. They also enjoy improved physical and mental health, with 71% feeling less burnt out, 39% feeling less stressed and 54% feeling a reduction in negative emotions." +
							"SUSTAINABILITY" +
							"Reduce the carbon footprint of your business through reduced commuting and energy use, as well as enabling more sustainable lifestyle changes among your workforce outside of work. Our research found that commuting time falls by an average of half an hour per person per week." +
							"GENDER EQUALITY" +
							"Enable a better distribution of caring responsibilities between parents, while levelling the playing field by reducing barriers to women achieving senior positions at work and reducing childcare costs. Men on a 4 day week are found to take on a greater share of housework and even more childcare, while 21% of employees report a reduction in childcare costs." +
							"INNOVATION" +
							"Future proof your business to the changes brought about by the pandemic and the fourth industrial revolution of artificial intelligence, automation and digital technologies. Being an early adapter and a market leader will establish you as an innovative, progressive and forward-thinking business that stands out from your competition."));
			petition.save(new com.example.bartspetitions.model.Petition(3L,"Ending Nuclear Tests",
					"Nuclear testing is a key step" +
					" in the development of nuclear weapons. By ending this, the CTBT curbs all nuclear arms" +
					" proliferation, be it the development of nuclear weapons by countries that do not currently have" +
					" them, upgrades to current nuclear arsenals or the creation of new, more advanced generations of" +
					" nuclear weapons.",
					"A key part of the global nuclear arms control framework " +
					"The CTBT is an essential component of the international nuclear arms control and disarmament framework. " +
					"Nuclear testing is a key step in the development of nuclear weapons. By ending this, the CTBT curbs all nuclear arms proliferation, be it the development of nuclear weapons by countries that do not currently have them, upgrades to current nuclear arsenals or the creation of new, more advanced generations of nuclear weapons. " +
					"The CTBT is fundamental to nuclear disarmament because it establishes trust that any clandestine nuclear test will be detected. " +
					"The CTBT has an intrinsic, complementary relationship with the landmark Treaty on the Non-Proliferation of Nuclear Weapons (NPT), the cornerstone of the global nuclear non-proliferation and disarmament regime, which recognizes the crucial importance of ending nuclear test explosions. " +
					"The CTBT prevents the serious health and environmental impacts of nuclear tests. " +
					"A global norm against nuclear testing " +
					"The CTBT has created a firm and virtually unchallenged global norm against nuclear testing. Tests have been conducted on only 10 occasions since it opened for signature in 1996, compared with more than 2,000 over the five previous decades. In this century, only one country – North Korea – has breached the norm and tested nuclear weapons. " +
					"Near-universal support " +
					"The CTBT has near-universal support, signed by 187 countries to date and ratified by 177. However, 44 specific nuclear technology holder countries must sign and ratify before the CTBT can enter into force as international law. Ratification by nine of these Annex 2 states is still required: by China, Egypt, India, Iran, Israel, North Korea, Pakistan, the Russian Federation and the United States. Of these, India, North Korea, and Pakistan are yet to sign the Treaty. " +
					"The mission of the CTBTO " +
					"Known formally as the Preparatory Commission for the Comprehensive Nuclear-Test-Ban Treaty Organization, the CTBTO exists to prepare for the Treaty’s entry into force. It has two main tasks: " +
					"Promoting universal recognition of the Treaty; and " +
					"Building up the CTBT verification regime to ensure no nuclear explosion can go undetected. " +
					"Headquartered in Vienna, Austria, the CTBTO has approximately 300 staff from over 90 countries and is led by Executive Secretary Robert Floyd. " +
					"A unique verification regime " +
					"The Treaty’s comprehensive verification regime consists of three components: " +
					"The International Monitoring System (IMS) is a unique global network using four state-of-the-art technologies: seismic to monitor shockwaves through the ground; hydroacoustic to detect sound waves in the oceans; infrasound to listen for ultra-low-frequency sound waves inaudible to the human ear; and radionuclide to monitor the atmosphere for radioactive particles and gases from a nuclear explosion. Around 90 percent of the Treaty’s 337 IMS facilities are already up and running and the system has proved its effectiveness, detecting all of North Korea’s declared nuclear tests. " +
					"The International Data Centre (IDC) at the CTBTO's headquarters in Vienna receives data from the global monitoring stations. The data are processed and distributed to the CTBTO's Member States in both raw and analyzed form. Member States received information about the location, magnitude, time and depth of North Korea’s nuclear tests within two hours. " +
					"On-Site Inspections (OSI) will be possible once the CTBT enters into force, if requested and approved by Member States, in order to collect evidence on the ground if data from the IMS indicate that a nuclear test may have taken place. " +
					"Additional benefits: from tsunami warnings to climate research " +
					"Beyond the core purpose of detecting nuclear explosions, IMS data yield a range of wider benefits that can help save lives and expand scientific knowledge. For example: " +
					"National tsunami warning centres in Member States can receive data in near-real time to support faster, more accurate public alerts. " +
					"IMS stations can contribute to the international response to a nuclear emergency by tracking the movement of harmful radionuclides. " +
					"Researchers can access selected data to better understand the natural world, from whale behaviour to climate change or the timing of monsoon rains. "));
			petition.save(new com.example.bartspetitions.model.Petition(4L,"Stop War in Ukraine",
			"As Ukraine continues to fight to liberate its occupied territories and eject Russian invaders, its Western backers debate the likely endgame for the war and its aftermath. The unanimous conclusion of the authors is that the only outcome to the war that can safeguard the future security of Europe is a convincing Ukrainian victory – hence, Western military support to Kyiv should be redoubled before it is too late.",
			"It’s now or never for Ukraine. A protracted or frozen conflict benefits Russia and hurts Ukraine, as does a ceasefire or negotiated settlement on Russia’s terms. If Ukraine is to avoid these outcomes and turn tenacious defence and incremental battlefield gains into outright victory, it needs far more ambitious international military assistance than it has received to date. This report presents the case for an immediate and decisive increase in such support, seeks to dispel overhyped concerns about provoking Russia, and counsels against accommodating Moscow’s demands." +
					"Ukraine’s need is all the more pressing because the United States – the principal donor of financial and military aid to Kyiv – is entering an election cycle that could soon reduce US foreign policy engagement or ultimately result in a more inward-looking administration in Washington. Increasing the West’s supply of weaponry for Ukraine now would, in addition to helping ongoing military actions against Russian forces, provide a measure of insulation against any future weakening of US solidarity." +
					"The argument for Western military and diplomatic resolve is reinforced by the impacts of Russian aggression beyond Ukraine itself. Not only is European security under threat, but the viability of the rules-based international order is potentially at stake. With this full-scale invasion, Russia has directly challenged arrangements that have helped to secure peace for over 70 years. The world will be safer with Russia defeated soundly on the battlefield than with an ambiguous outcome that, for instance, institutionalizes Ukrainian territorial losses." +
					"The search for peace is fraught with pitfalls. Any temporary solution that preserves, or partially preserves, the battlefield status quo will buy time for Russian forces to regroup after recent heavy losses and prepare for the next onslaught, while leaving Ukraine enfeebled and less than fully sovereign. While a diplomatic solution seems attractive to many in the West, and may suspend hostilities for a period, it would merely postpone an essential reckoning with Russia and is pointless without an achievable long-term plan for Ukraine’s security in place." +
					"Any such plan must set out the conditions for, and pathway towards, a durable peace on Ukraine’s terms. It must enshrine the principle of respect for the country’s sovereign independence and pre-2014 territorial borders. It must also envision future security and political guarantees. The plan’s chances of success will be greater if it supports Ukraine’s aspirations for NATO and EU membership. NATO and other international allies of Ukraine will need to develop this plan jointly with the Ukrainian government, and must remain committed to implementing it." +
					"A stalemate in the war or military setbacks for Ukraine would increase pressure, including potentially from Western allies, for compromise. Calls for ‘pragmatism’ – often a euphemism for granting Russia its demands – are even now proliferating. To counter narratives that might lead in this direction, this report analyses nine commonly articulated fallacies about the approaches the West should adopt – and avoid – in the search for peace. These fallacies broadly fit into two categories: ideas on accommodating Russia’s stated interests to accelerate a peace agreement; and objections to increasing military and other assistance to Ukraine." +
					"Although often well-intentioned, and despite their prominence in policy commentary as serious options for ending the war or avoiding escalation, such ideas are misguided, we argue. Most current suggestions for a settlement would, if implemented, crystallize Russian territorial gains and encourage further aggression in the future. Similarly, restraint in backing Ukraine for fear of provoking Russian reprisals is misplaced. By ignoring the true nature and agenda of Moscow’s regime and the futility of hoping to engage Vladimir Putin in negotiations in good faith, most ‘realist’ arguments for mitigating risk are in fact less realistic than the name suggests." +
					"Backing a full and unambiguous Ukrainian victory is therefore essential not only on moral but also practical grounds. Although recent increases in Western supplies of munitions and other hardware are welcome, the fundamental solution to many of the problems raised in this report remains: that Ukraine still needs a massive influx of weaponry. Without it, Ukraine will cease to exist as a sovereign state and an emboldened Russia will continue its imperialist campaign of expansionism against neighbours and aggression against perceived adversaries, democratic and otherwise, the world over. In the longer term, backing Ukraine will serve to deter other aggressors while potentially sowing the seeds for positive political change in Russia."));


			// Save a few signatures
			petitionPersonRepository.save(new PetitionPerson(1L,1L));
			petitionPersonRepository.save(new PetitionPerson(1L,2L));
			petitionPersonRepository.save(new PetitionPerson(1L,4L));
			petitionPersonRepository.save(new PetitionPerson(2L,2L));
			petitionPersonRepository.save(new PetitionPerson(2L,3L));
			petitionPersonRepository.save(new PetitionPerson(3L,1L));
			petitionPersonRepository.save(new PetitionPerson(3L,3L));
			petitionPersonRepository.save(new PetitionPerson(3L,4L));
			petitionPersonRepository.save(new PetitionPerson(4L,1L));
			
		};
	}
}