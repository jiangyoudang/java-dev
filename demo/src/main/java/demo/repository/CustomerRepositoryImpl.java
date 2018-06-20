package demo.repository;

import demo.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  @Value("${test_name}")
  private String test_property;

  @Override
  public List<Customer> findAll() {
    List<Customer> customers = new ArrayList<>();

    Customer c = new Customer();
    c.setFirstname("cong");
    c.setLastname("test");


    customers.add(c);

    System.out.println(test_property);


    return customers;
  }


}
