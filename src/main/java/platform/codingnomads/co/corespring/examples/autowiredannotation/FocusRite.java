package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("focusrite")
@ToString
public class FocusRite implements SoundCard {
}
