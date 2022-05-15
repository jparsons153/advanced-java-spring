package platform.codingnomads.co.ioc.examples.dependencylookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IOCDemoConfiguration {

    @Bean
    public GreetingProvider provider() {
        return new CodingNomadsGreetingProvider();
    }


    @Bean
    public GreetingRenderer renderer() {
        GreetingRenderer renderer =
                new StandardOutGreetingRenderer();
        renderer.setGreetingProvider(provider());
        return renderer;
    }

    @Bean
    public GreetingProvider johngreetingprovider() {return new JohnGreetingProvider();}

    @Bean
    public GreetingRenderer jprenderer() {
        GreetingRenderer jprenderer =
                new StandardOutGreetingRenderer();
        jprenderer.setGreetingProvider(johngreetingprovider());
        return jprenderer;

    }
}