package demo.repository;

import demo.model.Customer;
import java.util.List;

public interface CustomerRepository {

  List<Customer> findAll();
}
