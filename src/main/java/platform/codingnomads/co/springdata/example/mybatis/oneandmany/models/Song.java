package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Song {

    private Long id;

    private String name;

    private String albumName;

    private Artist artist;

    //song length in seconds
    private int songLength;

}
