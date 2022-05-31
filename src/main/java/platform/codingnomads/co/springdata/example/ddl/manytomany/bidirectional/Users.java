package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.*;
import platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample.Post;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
