package platform.codingnomads.co.ioc.lab_;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodingNomadDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                CodingNomadConfiguration.class);
        platform.codingnomads.co.ioc.lab_.CodingNomad codingNomad = ctx.getBean(CodingNomad.class);
        System.out.println(codingNomad.createAwesomeSoftware());
    }
}