package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query("SELECT st FROM SoilType st")
    ArrayList<SoilType>getSoilType();

    @Query("SELECT st FROM SoilType st WHERE dry = nativeQuery = true")
    ArrayList<SoilType>getDrySoil();

    @Query("SELECT st FROM SoilType st WHERE dry = true")
    ArrayList<SoilType> getSoilTypeBasedOnDry(Sort sort);

   // @Query("SELECT st FROM SoilType st")
   // SoilType<SoilType> getPagedSoilType(Pageable pageable);

//    @Query("SELECT st FROM SoilType st WHERE pH > ?4 AND pH < ?9")
//    ArrayList<SoilType> getSoilTypeBasedonPH(int minPH, int maxPH);
}
