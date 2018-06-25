package demo.repository;

import demo.model.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//public interface CustomerRepository extends CrudRepository<Customer, Long> {
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

//  List<Customer> findAll();
  List<Customer> findByLastname(@Param("name") String name);
}
