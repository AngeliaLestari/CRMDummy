package sg.edu.iss.club.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
