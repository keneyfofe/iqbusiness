package za.co.iqbusiness;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import za.co.iqbusiness.entity.Person;
import za.co.iqbusiness.repository.PersonRepository;



@DataJpaTest

@AutoConfigureTestDatabase(replace = Replace.NONE)

@Rollback(false)
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void addPerson() {
		Person person = new Person();
		
		person.setIdNumber(923738789);
		person.setFullName("Peter Jones");
		person.setTelephoneNumber(0766666667);
		
		
		Person savedPerson = personRepository.save(person);

		Person existPerson = entityManager.find(Person.class, savedPerson.getIdNumber());
		assertThat(existPerson.getFullName()).isEqualTo(person.getFullName());

	

}
}
