package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello Spring Developer!";
    }

    public String customGreeting() {return "Hello Java Spring Developer!";}
}
