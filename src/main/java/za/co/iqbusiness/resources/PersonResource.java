package za.co.iqbusiness.resources;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import za.co.iqbusiness.entity.Person;
import za.co.iqbusiness.services.PersonService;
import za.co.iqbusiness.services.RegistrationService;




@RestController
@RequestMapping("/")
public class PersonResource {
	
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private PersonService PersonService;

	@PostMapping("/registerPerson")
	@CrossOrigin(origins = "http://localhost:4200")
	public Person registerPerson(@RequestBody Person person) throws Exception {

		long tempIdNumber = person.getIdNumber();

		if (tempIdNumber != 0L && !"".equals(tempIdNumber)) {

			Person personObj  = registrationService.fetchPersonByIdNumber(tempIdNumber);

			if (personObj != null) {
				throw new Exception("user with " + tempIdNumber + "already exist");

			}

		}

		Person personObj = null;

		personObj  = registrationService.addPerson(person);
		return personObj;

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/findAllPerson")
	public List<Person> findAllPerson() {
		return PersonService.findAllPersons();
		
	}


}
