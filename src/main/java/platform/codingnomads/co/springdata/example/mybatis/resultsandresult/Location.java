package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {

    private Long id;
    private String placeName;
    private String address;
    private String postcode;

    public Location(Long id, String placeName, String address, String postcode) {
        this.id = id;
        this.placeName = placeName;
        this.address = address;
        this.postcode = postcode;
    }
}
