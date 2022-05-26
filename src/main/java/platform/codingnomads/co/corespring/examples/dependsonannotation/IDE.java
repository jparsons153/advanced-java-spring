package platform.codingnomads.co.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class IDE {
    @Autowired
    private JDK jdk;

    public IDE() {
        System.out.println("IDE is ready.");
    }

}
