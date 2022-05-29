package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("radeon")
@ToString
@Primary
public class Radeon implements VideoCard {
}
