package net.imane.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.imane.accountservice.enums.AccountType;
import net.imane.accountservice.model.Customer;

import java.util.Date;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private Date createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
