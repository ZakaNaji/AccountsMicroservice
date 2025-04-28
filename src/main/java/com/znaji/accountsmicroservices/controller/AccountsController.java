package com.znaji.accountsmicroservices.controller;

import com.znaji.accountsmicroservices.constants.AccountsConstants;
import com.znaji.accountsmicroservices.dto.CustomerDto;
import com.znaji.accountsmicroservices.dto.ResponseDto;
import com.znaji.accountsmicroservices.service.AccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomerDetail(@RequestParam("mobileNumber")
                                                               @Pattern(regexp = "$|[0-9]{10}")
                                                               String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }
}
