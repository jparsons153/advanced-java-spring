package platform.codingnomads.co.springtest.usingtestresttemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import platform.codingnomads.co.springtest.usingtestresttemplate.NoSuchCoffeeException;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }

    public CoffeePreference getCoffeeById(Long id) throws NoSuchCoffeeException{
        Optional<CoffeePreference> coffeeOptional = repo.findById(id);

        if (coffeeOptional.isEmpty()){
            throw new NoSuchCoffeeException("No coffee with ID " + id + " could be found.");
        }

        CoffeePreference coffee = coffeeOptional.get();
        return coffee;
    }
}