package com.znaji.accountsmicroservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name can't be null or empty.")
    @Size(min = 5, max = 30, message = "Name should have btw 5 and 30 characters.")
    private String name;
    @NotEmpty(message = "Email can't be empty or null.")
    @Email
    private String email;
    @NotEmpty(message = "MobileNumber can't be empty or null.")
    @Pattern(regexp = "$|[0-9]{10}", message = "MobileNumber should be 10 digits.")
    private String mobileNumber;
    private AccountsDto accountsDto;
}
