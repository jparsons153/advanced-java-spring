package platform.codingnomads.co.ioc.lab_;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class JDK {
    private String name;
    private String version;
}
