package platform.codingnomads.co.springdata.example.ddl.joincolumn;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "groupName")
@NoArgsConstructor
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "groupName")
    private String groupName;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumns({

            @JoinColumn(name = "field_id", referencedColumnName = "id"),
            //define the second join column. It will be called references_name and references the name column in the user table
            @JoinColumn(name = "field_name", referencedColumnName = "fieldName")
    })

    private Field field;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns({

            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            //define the second join column. It will be called references_name and references the name column in the user table
            @JoinColumn(name = "user_name", referencedColumnName = "name")
    })

    private User u;

}
