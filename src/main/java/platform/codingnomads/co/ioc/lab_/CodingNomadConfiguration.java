package platform.codingnomads.co.ioc.lab_;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab_")
public class CodingNomadConfiguration {

    @Bean
    public platform.codingnomads.co.ioc.lab_.Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public platform.codingnomads.co.ioc.lab_.IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("2021.1").build();
    }

    @Bean
    public platform.codingnomads.co.ioc.lab_.JDK jdk() {
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public OperatingSystem operatingSystem() {
        return OperatingSystem.builder().name("macOS").version("11.4").build();
    }

    @Bean
    public SoundSystem soundSystem() {
        return SoundSystem.builder().type("Speakers").brand("Bose").build();
    }

    @Bean
    public GamingMonitor gamingMonitor(){return GamingMonitor.builder().make("Acer").model("A").size(27).build();}

    @Bean
    public Ancillaries ancillaries(){return Ancillaries.builder().make("Logitech").model("abc").build();}
}
