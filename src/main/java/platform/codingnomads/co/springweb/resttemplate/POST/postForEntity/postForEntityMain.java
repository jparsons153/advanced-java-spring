package platform.codingnomads.co.springweb.resttemplate.POST.postForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.TaskResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

import java.util.Objects;

@SpringBootApplication
public class postForEntityMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForEntityMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("learn how to use postForEntity()")
//                    .description("get comfortable using the RestTemplate postForEntity() method")
//                    .userId(5)
//                    .completed(false)
//                    .build();
//
//            ResponseEntity<TaskResponseObject> responseEntity = restTemplate
//                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);
//
//            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
//                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
//            } else {
//                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
//            }

            // Posting new user using postForEntity
//            User newUser2 = User.builder()
//                    .email("jane.bloggs@gmail.com")
//                    .first_name("Jane")
//                    .last_name("Bloggs")
//                    .build();
//
//            ResponseEntity<UserResponseObject> user2ReturnedByServerAfterPost = restTemplate.postForEntity("http://demo.codingnomads.co:8080/tasks_api/users",newUser2, UserResponseObject.class);
//
//            if (user2ReturnedByServerAfterPost.getStatusCode().equals(HttpStatus.CREATED)) {
//                System.out.println(Objects.requireNonNull(user2ReturnedByServerAfterPost.getBody()));
//            } else {
//                System.out.println(Objects.requireNonNull(user2ReturnedByServerAfterPost.getBody()).getError());
//            }

            User newUser3 = User.builder()
                    .email("James.smith@gmail.com")
                    .last_name("Smith")
                    .build();

            ResponseEntity<UserResponseObject> user3ReturnedByServerAfterPost = restTemplate.postForEntity("http://demo.codingnomads.co:8080/tasks_api/users",newUser3, UserResponseObject.class);

            if (user3ReturnedByServerAfterPost.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(user3ReturnedByServerAfterPost.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(user3ReturnedByServerAfterPost.getBody()).getError());
            }

        };
    }
}
