package platform.codingnomads.co.springtest.understandingandusingprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("understanding_and_using_profiles")
public class TestMain implements CommandLineRunner {

    @Autowired
    CoffeePreferenceRepo repo;

    @Override
    public void run(String... args) throws Exception {

        repo.save(CoffeePreference.builder()
                .type("Americano")
                .iced(true)
                .size(CoffeePreference.Size.LARGE)
                .intensity(7)
                .sugar(false)
                .build());

        repo.save(CoffeePreference.builder()
                .type("Espresso")
                .iced(false)
                .size(CoffeePreference.Size.SMALL)
                .intensity(4)
                .sugar(true)
                .build());

        printMessage();
    }

    @Bean
    @Profile({"understanding_and_using_profiles"})
    public void printMessage(){
        System.out.println("printing message to the console");
    }
}
