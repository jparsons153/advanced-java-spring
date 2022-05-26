package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")

public class ProductOwner {
    public ProductOwner() {
        System.out.println("ProductOwner is ready.");
    }
}
