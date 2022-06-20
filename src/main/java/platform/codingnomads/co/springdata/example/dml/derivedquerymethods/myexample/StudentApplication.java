package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.List;

public class StudentApplication implements CommandLineRunner {

    @Autowired
    StudentEmailAddressRepo studentEmailAddressRepo;

    @Autowired
    StudentRepo studentrepo;

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class);}

    @Override
    public void run(String... args) throws Exception {
        final StudentEmailAddress joe_bloggs = StudentEmailAddress.builder().studentemailAddress("joebloggs@highschool.com").build();
        final StudentEmailAddress jo_joanna = StudentEmailAddress.builder().studentemailAddress("jojoanna@highschool.com").build();
        final StudentEmailAddress chuck_norris = StudentEmailAddress.builder().studentemailAddress("chucknorris@highschool.com").build();

        final List<StudentEmailAddress> studentEmailAddresses = Arrays.asList(joe_bloggs, jo_joanna, chuck_norris);

        if (studentEmailAddressRepo.findAll().isEmpty()) {
            studentEmailAddressRepo.saveAll(studentEmailAddresses);
        }

        final List<student> students = Arrays.asList(
                student.builder().firstName("Joe").lastName("Bloggs").studentEmailAddress(joe_bloggs).active(true).age(18).build(),
                student.builder().firstName("Jo").lastName("Joanna").studentEmailAddress(jo_joanna).active(true).age(16).build(),
                student.builder().firstName("Chuck").lastName("Norris").studentEmailAddress(chuck_norris).active(true).age(17).build()
        );

        if (studentrepo.findAll().isEmpty()){
            studentrepo.saveAll(students);
        }

        System.out.println("Finding by last name Norris " + studentrepo.findByLastNameIs("Norris"));

        System.out.println("Finding by first name Chuck " + studentrepo.findByFirstNameIs("Chuck"));

        // findByAgeLessThan
        System.out.println("Finding by age less than 18 " + studentrepo.findByAgeLessThan(18));

        // findByAgeLessThanEqual
        System.out.println("Finding by age less or equal to 18 " + studentrepo.findByAgeLessThanEqual(18));

        // findByAgeGreaterThan
        System.out.println("Finding by age greater than 16 " + studentrepo.findByAgeGreaterThan(16));

        // findByAgeGreaterThanEqual
        System.out.println("Finding by age greater than or equal to 16 " + studentrepo.findByAgeGreaterThanEqual(16));

        // findTop2ByLastName
        System.out.println("Finding by top 2 last name Norris " + studentrepo.findTop2ByLastName("Norris"));

        // findTop2ByFirstName
        System.out.println("Finding by top 2 last name Chuck " + studentrepo.findTop2ByFirstName("Chuck"));

        // findByLastNameOrderByFirstNameAsc
        System.out.println("Finding by last name Norris " + studentrepo.findByLastNameOrderByFirstNameAsc("Norris"));
        
        }
    }
