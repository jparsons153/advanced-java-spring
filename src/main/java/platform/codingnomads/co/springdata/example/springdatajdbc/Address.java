package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Address {
    private long id;
    private String streetName, postCode;

    public Address(long id, String streetName, String postCode) {
        this.id = id;
        this.streetName = streetName;
        this.postCode = postCode;
    }
}
