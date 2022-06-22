package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface LocationMapper {

    @Insert("INSERT INTO mybatis.location " +
    "(place_name, address, postcode) " +
    "VALUES (#{placeName}, #{address}, #{postcode});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertLocation(Location location);

    @Select("SELECT * " +
            "FROM mybatis.location " +
            "WHERE id = #{param1};")
    @Results(
            id = "locationResultMap",
            value = {
                    @Result(property = "placeName", column = "place_name"),
                    @Result(property = "address", column = "address"),
                    @Result(property = "postcode", column = "postcode")
            }
    )
    Location getLocationById(Long id);

    @Select("SELECT * " +
            "FROM mybatis.location " +
            "WHERE name = #{param1};")
    @ResultMap("locationResultMap")
    ArrayList<Song> getLocationByName(String name);

    @Update("UPDATE mybatis.location " +
            "SET name = #{name}, place_name = #{placeName}, address = #{address}, postcode = #{postcode} " +
            "WHERE id = #{id};")
    void updateLocation(Location location);

    @Delete("DELETE FROM mybatis.location WHERE id = #{param1};")
    void deletelocationById(Long locationId);
}
