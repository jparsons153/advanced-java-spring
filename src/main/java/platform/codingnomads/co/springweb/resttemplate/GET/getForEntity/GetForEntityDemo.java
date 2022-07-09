package platform.codingnomads.co.springweb.resttemplate.GET.getForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.BoredTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.KanyeTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            // Kanye quote
            System.out.println("Printing Kanye West quote");
            ResponseEntity<KanyeTemplate> responseEntity =
                    restTemplate.getForEntity("https://api.kanye.rest", KanyeTemplate.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                KanyeTemplate kanyeTemplate = responseEntity.getBody();
                System.out.println(kanyeTemplate.getQuote());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            // Bored activity
            System.out.println("\n" + "Printing random activity from Bored API");
            ResponseEntity<BoredTemplate> boredTemplateResponseEntity =
                    restTemplate.getForEntity("http://www.boredapi.com/api/activity/",BoredTemplate.class);

            if (boredTemplateResponseEntity.getStatusCode().equals(HttpStatus.OK) && boredTemplateResponseEntity.getBody() != null) {
                BoredTemplate boredTemplate = boredTemplateResponseEntity.getBody();
                System.out.println(boredTemplate.getActivity());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            // Bored activity using key
            System.out.println("\n" + "Printing activity from Bored API using key");
            ResponseEntity<BoredTemplate> boredTemplateResponseEntity2 =
                    restTemplate.getForEntity("http://www.boredapi.com/api/activity?key=5881028",BoredTemplate.class);

            if (boredTemplateResponseEntity2.getStatusCode().equals(HttpStatus.OK) && boredTemplateResponseEntity2.getBody() != null) {
                BoredTemplate boredTemplate2 = boredTemplateResponseEntity2.getBody();
                System.out.println(boredTemplate2.getActivity());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            // Bored activity with given type
            System.out.println("\n" + "Printing activity from Bored API with given type");
            ResponseEntity<BoredTemplate> boredTemplateResponseEntity3 =
                    restTemplate.getForEntity("http://www.boredapi.com/api/activity?type=education",BoredTemplate.class);

            if (boredTemplateResponseEntity3.getStatusCode().equals(HttpStatus.OK) && boredTemplateResponseEntity3.getBody() != null) {
                BoredTemplate boredTemplate3 = boredTemplateResponseEntity3.getBody();
                System.out.println(boredTemplate3.getActivity());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            // Bored activity using map

            Map<String, String> params = new HashMap<>();
            params.put("type", "activity?type=recreational");

            System.out.println("\n" + "Printing activity from Bored API using map");
            ResponseEntity<BoredTemplate> boredTemplateResponseEntity4 =
                    restTemplate.getForEntity("http://www.boredapi.com/api/",BoredTemplate.class,params);

            if (boredTemplateResponseEntity4.getStatusCode().equals(HttpStatus.OK) && boredTemplateResponseEntity4.getBody() != null) {
                BoredTemplate boredTemplate4 = boredTemplateResponseEntity4.getBody();
                System.out.println(boredTemplate4.getActivity());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

        };
    }
}
