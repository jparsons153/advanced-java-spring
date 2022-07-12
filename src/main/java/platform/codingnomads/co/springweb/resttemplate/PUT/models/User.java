package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long id;
    private String email;
    private String first_name;
    private String last_name;
    private long created_at;
    private long updated_at;
}
