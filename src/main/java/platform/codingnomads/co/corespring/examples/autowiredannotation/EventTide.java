package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("eventide")
@ToString
public class EventTide implements SoundCard {
}
