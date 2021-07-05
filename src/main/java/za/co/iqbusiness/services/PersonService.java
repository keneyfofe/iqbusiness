package za.co.iqbusiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.iqbusiness.entity.Person;
import za.co.iqbusiness.repository.PersonRepository;


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAllPersons(){
		return personRepository.findAll();
	}


}
