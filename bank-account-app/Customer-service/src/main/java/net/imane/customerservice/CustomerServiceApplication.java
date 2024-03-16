package net.imane.customerservice;

import net.imane.customerservice.config.GlobalConfig;
import net.imane.customerservice.entities.Customer;
import net.imane.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			Customer customer1= Customer.builder()
					.firstName("hassan")
					.lastName("amrani")
					.email("amrani@gmail.com")
					.build();
			customerRepository.save(customer1);
			Customer customer2= Customer.builder()
					.firstName("Mohamed")
					.lastName("adnan")
					.email("adnan@gmail.com")
					.build();
			customerRepository.save(customer2);
		};
	}
}
