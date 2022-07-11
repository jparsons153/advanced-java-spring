package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.TaskResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

@SpringBootApplication
public class postForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForObjectMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForObject()")
                    .description("get comfortable using the RestTemplate postForObject() method")
                    .userId(5)
                    .completed(false)
                    .build();

            TaskResponseObject taskReturnedByServerAfterPost = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);

            if (taskReturnedByServerAfterPost != null) {
                System.out.println(taskReturnedByServerAfterPost);
            }
            // Posting new user using postForObject
            User newUser = User.builder()
                    .email("john.bloggs@gmail.com")
                    .first_name("John")
                    .last_name("Bloggs")
                    .build();

            UserResponseObject userReturnedByServerAfterPost = restTemplate.postForObject("http://demo.codingnomads.co:8080/tasks_api/users",newUser, UserResponseObject.class);

            if (userReturnedByServerAfterPost != null) {
                System.out.println(userReturnedByServerAfterPost);
            }

        };
    }
}
