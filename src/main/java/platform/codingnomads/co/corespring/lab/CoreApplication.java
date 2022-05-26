package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;
import platform.codingnomads.co.corespring.lab.complete.Record;
import platform.codingnomads.co.corespring.lab.complete.Turntable;

@SpringBootApplication
public class CoreApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                LabConfig.class);

        Band band = ctx.getBean(Band.class);

        System.out.println("Ready for the " + band.getGenre() + "band to play, welcoming the "
                + band.getBandName());

        String[] song = ctx.getBeanNamesForType(Song.class);

        for (String track : song) {
            System.out.println("Now listening to " + ctx.getBean(track, Song.class).getAlbum()
                    + " by " + ctx.getBean(track, Song.class).getArtist() + ".");
        }

        System.out.println("Done for the day!");
    }
}
