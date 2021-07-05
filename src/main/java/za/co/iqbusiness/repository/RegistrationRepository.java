package za.co.iqbusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.iqbusiness.entity.Person;

@Repository
public interface RegistrationRepository extends JpaRepository<Person, Long> {

	Person findByIdNumber(long idNumber);

}
