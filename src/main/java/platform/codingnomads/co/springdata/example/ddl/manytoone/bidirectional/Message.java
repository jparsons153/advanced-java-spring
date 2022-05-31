package platform.codingnomads.co.springdata.example.ddl.manytoone.bidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    private Comment comment;
}
