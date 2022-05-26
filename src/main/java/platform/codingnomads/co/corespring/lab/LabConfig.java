package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/songs.xml"})

public class LabConfig {
    @Bean
    public Band band(){return new Band("4 men and a bass","Jazz");}
}
