package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.codewarriorexample.EmailAddress;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "email_address_id")
    private StudentEmailAddress studentEmailAddress;

    private Integer age;
    private Boolean active;
}
