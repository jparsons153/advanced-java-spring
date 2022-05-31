package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.*;
import platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional.Post;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
