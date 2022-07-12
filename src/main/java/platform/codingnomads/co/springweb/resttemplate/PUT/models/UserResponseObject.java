package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Data;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Error;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;

@Data
public class UserResponseObject {
    User data;
    Error error;
    String status;
}
