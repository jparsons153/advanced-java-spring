package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEmailAddressRepo extends JpaRepository<StudentEmailAddress, Long> {

    StudentEmailAddress findByEmailAddress(String studentemailAddress);
}