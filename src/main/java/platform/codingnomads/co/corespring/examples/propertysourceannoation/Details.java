package platform.codingnomads.co.corespring.examples.propertysourceannoation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Details {
    @Value("${detailsName}")
    private String detailsName;

    @Value("${detailsAddress}")
    private String detailsAddress;

    public String getDetailsName() {
        return detailsName;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }
}
