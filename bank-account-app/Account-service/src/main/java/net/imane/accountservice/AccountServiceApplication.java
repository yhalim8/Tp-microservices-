package net.imane.accountservice;

import net.imane.accountservice.client.CustomerRestClient;
import net.imane.accountservice.entities.BankAccount;
import net.imane.accountservice.enums.AccountType;
import net.imane.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
		@Bean
		CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository,
											CustomerRestClient customerRestClient){
			return args -> {
				customerRestClient.allCustomers().forEach(c->{
					BankAccount bankAccount=BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.type(AccountType.SAVING_ACCOUNT)
							.currency("MAD")
							.balance(Math.random()*56789)
							.customerId(c.getId())
							.createAt(new Date())
							.build();
					BankAccount bankAccount2=BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.type(AccountType.CURRENT_ACCOUNT)
							.currency("MAD")
							.balance(Math.random()*90000)
							.customerId(c.getId())
							.createAt(new Date())
							.build();
					bankAccountRepository.save(bankAccount);
					bankAccountRepository.save(bankAccount2);
				});

			};
		}
}
