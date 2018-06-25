package demo.service;

import demo.model.Customer;
import demo.repository.CustomerRepository;
//import demo.repository.CustomerRepositoryImpl;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @PersistenceContext
  private EntityManager em;

  public CustomerServiceImpl(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  public Iterable<Customer> findAll(){
    return customerRepository.findAll();
  }

  public Customer create(){
    Customer c = null;
    TypedQuery query = em.createQuery("select c from Customer c where c.firstname= ?1", Customer.class);

    query.setParameter(1, "cong");

    try{
      c = (Customer) query.getSingleResult();
      c.setLastname(String.valueOf(Integer.valueOf(c.getLastname())+1));
    }catch (NoResultException e){
      c = new Customer();
      c.setFirstname("cong");
      c.setLastname("1");
    }

    return customerRepository.save(c);
  }


}
