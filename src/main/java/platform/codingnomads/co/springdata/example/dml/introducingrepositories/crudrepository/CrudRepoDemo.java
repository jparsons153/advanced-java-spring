package platform.codingnomads.co.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    //autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        //create new user
        User user1 = User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 = User.builder().firstName("Joanne").lastName("Joanna").age(36).build();
        User joeBloggs = User.builder().firstName("Joe").lastName("Bloggs").age(21).build();
        User chuckNorris = User.builder().firstName("Chuck").lastName("Norris").age(45).build();

        // add users to arraylist
        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(user1);
        newUsers.add(user2);
        newUsers.add(joeBloggs);
        newUsers.add(chuckNorris);

        Iterable<User> users = userRepo.saveAll(newUsers);

        //save user and assign what is returned to the user variable.
        //user = userRepo.save(user);
        //user2 = userRepo.save(user2);

        Iterable<User> u = userRepo.findAll();

        for(User user : users){
            System.out.println(user.toString());
        }

        //delete the user using the id of the inserted user object
        //userRepo.deleteById(user.getId());
        //userRepo.deleteById(user2.getId());
    }
}
