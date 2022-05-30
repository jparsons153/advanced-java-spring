package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tyres")
@NoArgsConstructor
@Getter
@Setter

public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String tyreBrand;


    //note that this annotation and field is new
    //used to indicate that this is the child side of a relationship and refer the JPA
    //to the field in the Driver class that defines the relationship

    @OneToOne(mappedBy = "tyre")

    private Driver driver;

}
