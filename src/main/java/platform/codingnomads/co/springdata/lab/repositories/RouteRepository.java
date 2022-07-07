package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
