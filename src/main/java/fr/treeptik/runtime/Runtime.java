package fr.treeptik.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.model.Animal;
import fr.treeptik.model.Personne;
import fr.treeptik.service.PersonneService;

public class Runtime {
	
	public static void main(String[] args) throws ServiceException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonneService personneService = context.getBean(PersonneService.class);
		
//		List<Animal> animaux = new ArrayList<>();
//		Animal animal1 = new Animal();
//		animal1.setNom("Marguerite");
//		Animal animal2 = new Animal();
//		animal2.setNom("Georges");
//		animaux.add(animal1);
//		animaux.add(animal2);
//		
//		Personne personne = new Personne();
//		personne.setNom("Lenoir");
//		personne.setPrenom("Vincent");
//		personne.setDateNaissance(new Date());
//		personne.setAnimaux(animaux);
//		
//		personneService.save(personne);
		
		List<Animal> animaux = new ArrayList<>();
		Animal animal = new Animal();
		animal.setNom("Georgette");
		animaux.add(animal);
		
		Personne personne = personneService.findById(2);
		personne.setAnimaux(animaux);
		personneService.update(personne);
	}
}
