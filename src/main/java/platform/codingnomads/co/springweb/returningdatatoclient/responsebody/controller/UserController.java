package platform.codingnomads.co.springweb.returningdatatoclient.responsebody.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import platform.codingnomads.co.springweb.returningdatatoclient.responsebody.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.co")
            .build();

    public User user2 = User.builder()
            .id(101)
            .name("Java Vanilla")
            .email("vanilla@codingnomads.co")
            .build();

    public User user3 = User.builder()
            .id(102)
            .name("user 03")
            .email("user03@codingnomads.co")
            .build();

    public User user4 = User.builder()
            .id(103)
            .name("user 04")
            .email("user04@codingnomads.co")
            .build();

    //using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    //using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //returning a POJO without ResponseBody or using a ResponseEntity
    @GetMapping("/user")
    public User user() {
        return user;
    }

    @ResponseBody
    @GetMapping("/user-list")
    public List<User> userListResponseBody() {
        List<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    return userList;
    }

}
