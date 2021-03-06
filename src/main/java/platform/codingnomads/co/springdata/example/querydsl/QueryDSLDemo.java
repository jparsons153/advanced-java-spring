package platform.codingnomads.co.springdata.example.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.querydsl.models.*;
import platform.codingnomads.co.springdata.example.querydsl.repository.AreaRepository;
import platform.codingnomads.co.springdata.example.querydsl.repository.RouteRepository;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories("platform.codingnomads.co.springdata.example.querydsl.repository")
public class QueryDSLDemo implements CommandLineRunner {

    private final RouteRepository routeRepository;
    private final AreaRepository areaRepository;
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(QueryDSLDemo.class);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        final List<Area> areas = areaRepository.saveAll(
                Arrays.asList(
                        Area.builder().code("A").name("A").build(),
                        Area.builder().code("B").name("B").build(),
                        Area.builder().code("C").name("C").build(),
                        Area.builder().code("D").name("D").build(),
                        Area.builder().code("E").name("E").build(),
                        Area.builder().code("F").name("F").build(),
                        Area.builder().code("G").name("G").build()
                )
        );

        final List<Route> routes = routeRepository.saveAll(
                Arrays.asList(
                        Route.builder().code("A-B").name("A-B").origin(areaRepository.findByCode("A")).destination(areaRepository.findByCode("B")).build(),
                        Route.builder().code("B-C").name("B-C").origin(areaRepository.findByCode("B")).destination(areaRepository.findByCode("C")).build(),
                        Route.builder().code("C-D").name("C-D").origin(areaRepository.findByCode("C")).destination(areaRepository.findByCode("D")).build(),
                        Route.builder().code("D-E").name("D-E").origin(areaRepository.findByCode("D")).destination(areaRepository.findByCode("E")).build(),
                        Route.builder().code("E-F").name("E-F").origin(areaRepository.findByCode("E")).destination(areaRepository.findByCode("F")).build(),
                        Route.builder().code("F-G").name("F-G").origin(areaRepository.findByCode("F")).destination(areaRepository.findByCode("G")).build()
                )
        );

        final List<Route> routesByCode = routeRepository.findAllRoutesBySearchQuery(SearchQuery.builder().code("A-B").build());
      //  routesByCode.forEach(System.out::println);

        final List<Route> routesByCodeAndOrigin = routeRepository.findAllRoutesBySearchQuery(SearchQuery.builder().code("A-B").origin("A").build());

     //   routesByCodeAndOrigin.forEach(System.out::println);

        //query the database straight-up without using repository
//        QArea qArea = QArea.area;
//        JPAQuery<?> query = new JPAQuery<>(entityManager);
//        Area area = query.select(qArea)
//                .from(qArea)
//                .where(qArea.code.eq("A"))
//                .fetchOne();
//        System.out.println(area);

        System.out.println("\n"+"Queries added for exercise" + "\n");

        System.out.println("Query #1 using JPA Query where area code is C, fetch first");

        QArea qArea2 = QArea.area;
        JPAQuery<?> query2 = new JPAQuery<>(entityManager);
        Area area2 = query2.select(qArea2)
                .from(qArea2)
                .where(qArea2.code.eq("C"))
                .fetchFirst();
        System.out.println(area2);

        System.out.println("\n" + "Query #2 using JPA Query factory where area code is A, fetch all");

        QArea qArea3 = QArea.area;
        JPAQueryFactory query3 = new JPAQueryFactory(entityManager);
        List<Area> area3 = query3.selectFrom(qArea3)
                .where(qArea3.code.eq("A"))
                .fetch();
        area3.forEach(System.out::println);

        System.out.println("\n" + "Query #3 where area code contains B");

        QArea qArea4 = QArea.area;
        JPAQueryFactory query4 = new JPAQueryFactory(entityManager);
        List<Area> area4 = query4.selectFrom(qArea4)
                .where(qArea4.code.contains("B"))
                .fetch();
        area4.forEach(System.out::println);

        System.out.println("\n" + "Query #4 where area code is not null");

        QArea qArea5 = QArea.area;
        JPAQueryFactory query5 = new JPAQueryFactory(entityManager);
        List<Area> area5 = query5.selectFrom(qArea5)
                .where(qArea5.code.isNotNull())
                .fetch();
        area5.forEach(System.out::println);

        System.out.println("\n" +"Query #5 using JPA Query where route code is A-B, fetch one");

        QRoute qRoute = QRoute.route;
        JPAQuery<?> query6 = new JPAQuery<>(entityManager);
        Route route = query6.select(qRoute)
                .from(qRoute)
                .where(qRoute.code.eq("A-B"))
                .fetchOne();
        System.out.println(route);

        System.out.println("\n" +"Query #6 using JPA Query where route code contains B, fetch all");

        QRoute qRoute2 = QRoute.route;
        JPAQueryFactory query7 = new JPAQueryFactory(entityManager);
        List<Route> route2 = query7.selectFrom(qRoute2)
                .where(qRoute2.code.contains("B"))
                .fetch();
        route2.forEach(System.out::println);

        System.out.println("\n" + "Query #7 where route code is not null");

        QRoute qRoute3 = QRoute.route;
        JPAQueryFactory query8 = new JPAQueryFactory(entityManager);
        List<Route> route3 = query8.selectFrom(qRoute3)
                .where(qRoute3.code.isNotNull())
                .fetch();
        route3.forEach(System.out::println);

        System.out.println("\n" +"Deleting all..");

        routeRepository.deleteAll();
        areaRepository.deleteAll();
    }
}
