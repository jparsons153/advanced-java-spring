package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.CodeWarrior;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<student, Long> {

    List<student> findByLastNameIs(String lastName);

    List<student> findByFirstNameIs(String firstName);

    List<student> findByAgeLessThan(Integer age);

    List<student> findByAgeLessThanEqual(Integer age);

    List<student> findByAgeGreaterThan(Integer age);

    List<student> findByAgeGreaterThanEqual(Integer age);

    List<student> findTop2ByLastName(String lastName);

    List<student> findTop2ByFirstName(String firstName);

    List<student> findByLastNameOrderByFirstNameAsc(String lastName);

    student findByEmailAddress_EmailAddress(String emailAddress);

}
