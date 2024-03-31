package br.com.rcunha.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.rcunha.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName()); 
	
	public Person findById(String id) {

		logger.info("Finding one person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Ricardo");
		person.setLastName("da Cunha");
		person.setAddress("São Bernardo do Campo - São Paulo");
		person.setGender("Masculino");
		
		return person; 
	}
}
