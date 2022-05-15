package platform.codingnomads.co.ioc.examples.dependencylookup;

public class JohnGreetingProvider implements GreetingProvider {
    @Override
    public String getGreeting() {
        return "John here, Hello CodingNomads!";
    }

}
