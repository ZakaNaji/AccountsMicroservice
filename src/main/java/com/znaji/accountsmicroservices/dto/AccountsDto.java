package com.znaji.accountsmicroservices.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can't be empty or null.")
    @Pattern(regexp = "$|[0-9]{10}", message = "AccountNumber should be 10 digits.")
    private Long accountNumber;
    @NotEmpty(message = "Account type can't be empty or null.")
    private String  accountType;
    @NotEmpty(message = "Branch address can't be empty or null.")
    private String branchAddress;
}
