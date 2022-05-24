package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import platform.codingnomads.co.corespring.examples.autowiredannotation.DesktopComputer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PrimaryAnnotationDemo {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(PrimaryAnnotationDemo.class);
        ctx.close();
    }
}
