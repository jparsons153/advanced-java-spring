package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString

public class Album {
    private Album albumName;
    private List<Song> songs;
    private String name;
    private String year;

    public Album(Album albumName, List<Song> songs, String name, String year) {
        this.albumName = albumName;
        this.songs = songs;
        this.name = name;
        this.year = year;
    }
}
