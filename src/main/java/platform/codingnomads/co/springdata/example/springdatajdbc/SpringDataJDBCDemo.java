package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {
/*
        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");
*/
        // NEW POJO

        try {
            //create address table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE address (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "streetName VARCHAR(255) NOT NULL, postCode VARCHAR(255) NOT NULL );");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitAddress = Stream.of("hyperbole loop, AB11CDE")
                .map(address -> address.split(", "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Address into the database
        for (Object[] address : splitAddress) {
            jdbcTemplate.execute(String.format("INSERT INTO address(id, streetName, postCode) VALUES ('%s','%s','%s')", address[0], address[1], address[2]));
        }

        //query the database for Address
        jdbcTemplate.query(
                        "SELECT id, streetName, postcode FROM address WHERE streetName = 'hyperbole loop'",
                        (rs, rowNum) -> new Address(rs.getLong("id"), rs.getString("streetName"), rs.getString("postCode"))
                )
                //print each found address to the console
                .forEach(address -> System.out.println(address.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE address;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE address");

    }
}
