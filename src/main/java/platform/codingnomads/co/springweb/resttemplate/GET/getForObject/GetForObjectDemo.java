package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.getForObject.video_demo.CodingNomadsTasksApiResponse;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ExcuseTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.KanyeTemplate;

import java.util.Arrays;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            KanyeTemplate kanyeQuote = restTemplate.getForObject("https://api.kanye.rest/", KanyeTemplate.class);
            System.out.println(kanyeQuote.toString());

            // submit more requests here
            CodingNomadsTasksApiResponse response =
            restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
                            CodingNomadsTasksApiResponse.class);

            System.out.println(response.toString());

            // random excuse
            ExcuseTemplate[] excuse = restTemplate.getForObject("https://excuser.herokuapp.com/v1/excuse",ExcuseTemplate[].class);
            Arrays.stream(excuse).forEach(System.out::print);

            // get n random excuses for a specific category
            ExcuseTemplate[] excuse3 = restTemplate.getForObject("https://excuser.herokuapp.com/v1/excuse/office/4",ExcuseTemplate[].class);
            Arrays.stream(excuse3).forEach(System.out::print);

        };
    }
}
