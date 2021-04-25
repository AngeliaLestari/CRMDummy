package sg.edu.iss.club.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerName;
    private String address;
    private Integer contactNumber;
    private String contactPerson;

    //1 customer terhapus , service related terhapus
    @ManyToOne
    //(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //@JoinColumn(name="serviceId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Service service;
    //service is parent class



}
