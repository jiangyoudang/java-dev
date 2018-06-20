package demo.service;

import demo.model.Customer;
import demo.repository.CustomerRepository;
import demo.repository.CustomerRepositoryImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public CustomerServiceImpl(){
  }

  public List<Customer> findAll(){
    return customerRepository.findAll();
  }


}
