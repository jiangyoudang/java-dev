package demo.repository;

import demo.model.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

//  List<Customer> findAll();
}
