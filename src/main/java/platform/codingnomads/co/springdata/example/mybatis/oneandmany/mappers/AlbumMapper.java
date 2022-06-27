package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;

@Mapper
public interface AlbumMapper {
    @Insert("INSERT INTO mybatis.albums (album_name, year, artist_id, song_id) VALUES (#{albumName}, #{year}, #{artist.id}, #{song.id} );")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(
                    property = "songs",
                    column = "id",
                    javaType = ArrayList.class,
                    many = @Many(
                            select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId",
                            fetchType = FetchType.LAZY)
            )
    })
    Album getAlbumByIdWithSongs(Long id);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    Artist getAlbumByIdWithoutSongs(Long id);

//    @Select("SELECT * " +
//            "FROM mybatis.albums " +
//            "WHERE id = #{param1};")
//    @Results(
//            id = "albumResultMap",
//            value = {
//                    @Result(property = "albumName", column = "album_name"),
//                    @Result(property = "year", column = "year"),
//                    @Result(
//                            //property to map to
//                            property = "artist",
//                            column = "artist_id",
//                            javaType = Artist.class,
//                            one = @One(
//                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.ArtistMapper.getArtistByIdWithoutAlbums",
//                                    fetchType = FetchType.LAZY
//                            )
//                    )
//            }
//    )
//    Song getAlbumById(Long id);
}
