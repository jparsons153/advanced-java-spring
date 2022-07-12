package platform.codingnomads.co.springweb.resttemplate.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.UserResponseObject;

@SpringBootApplication
public class putMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(putMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            int taskId = 5;

            //request Task 5 from server
            ResponseObject responseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);

            //confirm data was retrieved & avoid NullPointerExceptions
            Task taskToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The task with ID " + taskId + " could not be found");
            } else {
                taskToUpdate = responseObject.getData();
            }

            //update the task information
            taskToUpdate.setName("updated using put()");
            taskToUpdate.setDescription("this task was updated using RestTemplate's put() method");
            taskToUpdate.setCompleted(true);

            //use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(), taskToUpdate);
            //get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);
            System.out.println(responseObject);

            taskToUpdate.setName("updated using exchange() PUT");
            taskToUpdate.setDescription("this task was updated using RestTemplate's exchange() method");

            //create an HttpEntity wrapping the task to update
            HttpEntity<Task> httpEntity = new HttpEntity<>(taskToUpdate);
            //use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<ResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(),
                    HttpMethod.PUT, httpEntity, ResponseObject.class);
            System.out.println(response);

            // update user using PUT
            int userID = 3;

            UserResponseObject responseObject2 = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userID, UserResponseObject.class);

            //confirm data was retrieved & avoid NullPointerExceptions
            User userToUpdate;
            if (responseObject2 == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject2.getData() == null) {
                throw new Exception("The task with ID " + taskId + " could not be found");
            } else {
                userToUpdate = responseObject2.getData();
            }

            //update the task information
            userToUpdate.setFirst_name("N");

            //use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(), userToUpdate);
            //get the task to verify update
            responseObject2 = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userID, UserResponseObject.class);
            System.out.println(responseObject2);

//            taskToUpdate.setName("updated using exchange() PUT");
//            taskToUpdate.setDescription("this task was updated using RestTemplate's exchange() method");

            //create an HttpEntity wrapping the task to update
            HttpEntity<User> httpEntity2 = new HttpEntity<>(userToUpdate);
            //use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<UserResponseObject> response2 = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(),
                    HttpMethod.PUT, httpEntity2, UserResponseObject.class);
            System.out.println(response2);

        };
    }
}
