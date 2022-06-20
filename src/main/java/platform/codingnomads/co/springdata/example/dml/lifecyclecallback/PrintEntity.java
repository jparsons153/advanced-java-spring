package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here

    @PrePersist
    @PreUpdate
    private void prepersistmethod(){
        System.out.println("This is a pre-persist, pre-update method");
    }

    @PostLoad
    private void postload(){
        System.out.println("This is a post-load method");
    }

    @PostUpdate
    private void postupdate(){
        System.out.println("This is a post-update method");
    }

    @PostRemove
    private void postremove(){
        System.out.println("This is a post remove method");
    }

}
