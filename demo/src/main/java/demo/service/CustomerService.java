package demo.service;

import demo.model.Customer;

public interface CustomerService {

  Iterable<Customer> findAll();

  Customer create();

}
