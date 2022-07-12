package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.User;

import java.util.*;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/helloWorld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() {
        return "Custom Hello World Greeting!";
    }

    @RequestMapping(path = "/taskslist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> task() {
        List<String> newList = new ArrayList<>();
            newList.add("item 01");
            newList.add("item 02");
            newList.add("item 03");
        return newList;
    }

    @RequestMapping(path = "/newUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
        User newUserTwo = User.builder()
                .first_name("John")
                .last_name("Doe")
                .email("john.doe@gmail.com")
                .build();
        return newUserTwo;
    }
}