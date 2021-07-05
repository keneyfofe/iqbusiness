package za.co.iqbusiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.iqbusiness.entity.Person;
import za.co.iqbusiness.repository.RegistrationRepository;



@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationRepo;
	
	

	public Person addPerson(Person person) {
		return registrationRepo.save(person);
	}

	public Person fetchPersonByIdNumber(long idNumber) {
		return registrationRepo.findByIdNumber(idNumber);
	}
	
	
}
