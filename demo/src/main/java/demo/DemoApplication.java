package demo;

import demo.model.Customer;
import demo.service.CustomerService;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

  @Autowired
  CustomerService customerService;

  public static void main(String[] args) {

//    ApplicationContext appContext =
//        new AnnotationConfigApplicationContext(AppConfig.class);
//
//
//
//
//
//    CustomerService service = appContext.getBean(CustomerService.class);
    SpringApplication.run(DemoApplication.class, args);

//    System.out.println(service.findAll().get(0).getFirstname());
  }

//  public DemoApplication(CustomerService customerService){
//    this.customerService = customerService;
//
//  }

  @RequestMapping("/home")
  public String home() {
    Iterator<Customer> customers = customerService.findAll().iterator();
    if (customers.hasNext()) {

      return customers.next().getLastname();
    }
    return "No record";

  }






}
