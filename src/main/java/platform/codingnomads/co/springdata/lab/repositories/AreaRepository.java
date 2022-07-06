package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.Area;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {
    Area findByCode(String code);

}
