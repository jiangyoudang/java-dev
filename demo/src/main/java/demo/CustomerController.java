package demo;


import demo.model.Customer;
//import demo.repository.CustomerRepositoryImpl;
import demo.service.CustomerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


  @Autowired
  CustomerService customerService;


  @RequestMapping("/create")
  public Customer create() {
    return customerService.create();

  }

  @RequestMapping("/all")
  public List<Customer> getAll() {

    List<Customer> customers = new ArrayList<>();
    for (Iterator<Customer> customerIterator = customerService.findAll().iterator();
        customerIterator.hasNext(); ) {
      customers.add(customerIterator.next());
    }

    return customers;
  }
}
