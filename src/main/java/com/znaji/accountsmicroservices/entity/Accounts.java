package com.znaji.accountsmicroservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Id
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;

}
