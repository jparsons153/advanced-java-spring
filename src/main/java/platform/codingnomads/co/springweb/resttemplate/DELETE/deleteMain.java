package platform.codingnomads.co.springweb.resttemplate.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

@ComponentScan(basePackages = "")
@SpringBootApplication
public class deleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(deleteMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // create & delete tasks
            Task newTask = Task.builder()
                    .name("should be deleted")
                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
                    .userId(5)
                    .completed(false)
                    .build();

            //POST new task to server
            ResponseObject responseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/", newTask, ResponseObject.class);

            //confirm data was returned & avoid NullPointerExceptions
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:" + responseObject.getError().getMessage());
            } else {
                newTask = responseObject.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(newTask);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId());
            System.out.println("The task was also successfully deleted");

            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            //delete using exchange()
            HttpEntity<Task> httpEntity = new HttpEntity<>(newTask);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/"
                        + newTask.getId(), HttpMethod.DELETE, httpEntity, ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            // Create & delete User
            User userToBeDeleted = User.builder()
                    .first_name("John")
                    .last_name("Doe")
                    .email("john.doe@gmail.com")
                    .build();

            //POST new task to server
            UserResponseObject responseObjectDelete = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users/", userToBeDeleted, UserResponseObject.class);

            //confirm data was returned & avoid NullPointerExceptions
            if (responseObjectDelete == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObjectDelete.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:" + responseObjectDelete.getError().getMessage());
            } else {
                userToBeDeleted = responseObjectDelete.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(userToBeDeleted);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + userToBeDeleted.getId());
            System.out.println("The user was also successfully deleted");

            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/users/" + userToBeDeleted.getId(), UserResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            //delete using exchange()
            HttpEntity<User> httpEntityUser = new HttpEntity<>(userToBeDeleted);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/"
                        + userToBeDeleted.getId(), HttpMethod.DELETE, httpEntityUser, ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

        };
    }
}
