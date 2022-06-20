package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentEmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentemailAddress;
}
