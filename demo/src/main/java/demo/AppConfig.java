package demo;

import demo.repository.CustomerRepository;
//import demo.repository.CustomerRepositoryImpl;
import demo.service.CustomerService;
import demo.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@ComponentScan
//@PropertySource("application.properties")
public class AppConfig {

//  @Bean(name = "customerRepository")
//  public CustomerRepository getCustomerRepository() {
//    return new CustomerRepositoryImpl();
//  }

//  @Bean(name = "customerService")
//  public CustomerService getCustomerService() {
//
//    CustomerServiceImpl customerService = new CustomerServiceImpl();
////    customerService.setCustomerRepository(getCustomerRepository());
//
//    return customerService;
//  }

}
