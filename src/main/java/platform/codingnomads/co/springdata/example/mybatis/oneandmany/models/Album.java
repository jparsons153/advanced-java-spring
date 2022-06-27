package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Album {
   // private Album albumName;
    //private List<Song> songs;
    private Long id;
    private String albumName;
    private String year;
    private Artist artist;
    private Song song;

}
