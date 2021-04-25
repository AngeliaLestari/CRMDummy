package sg.edu.iss.club.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String serviceType;
    private String description;

    //@OneToMany (mappedBy= "service", orphanRemoval = true)
   // private List<Customer> customer;



}
