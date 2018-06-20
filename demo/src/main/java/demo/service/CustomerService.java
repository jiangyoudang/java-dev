package demo.service;

import demo.model.Customer;
import demo.repository.CustomerRepository;
import java.util.List;

public interface CustomerService {

  List<Customer> findAll();


}
