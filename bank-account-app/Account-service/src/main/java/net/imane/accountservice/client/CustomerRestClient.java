package net.imane.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.imane.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customer-service",fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,Exception e){
         Customer customer=new Customer();
         customer.setId(id);
         customer.setFirstName("Not Available");
         customer.setLastName("Not Available");
         customer.setEmail("Not Available");
         return customer;
    }

    default List<Customer> getAllCustomers(Exception e){
        return List.of();
    }
}
