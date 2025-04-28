package com.znaji.accountsmicroservices.service.impl;

import com.znaji.accountsmicroservices.constants.AccountsConstants;
import com.znaji.accountsmicroservices.dto.AccountsMapper;
import com.znaji.accountsmicroservices.dto.CustomerDto;
import com.znaji.accountsmicroservices.dto.CustomerMapper;
import com.znaji.accountsmicroservices.entity.Accounts;
import com.znaji.accountsmicroservices.entity.Customer;
import com.znaji.accountsmicroservices.exception.CustomerExistAlreadyException;
import com.znaji.accountsmicroservices.exception.ResourceNotFound;
import com.znaji.accountsmicroservices.repository.AccountsRepository;
import com.znaji.accountsmicroservices.repository.CustomerRepository;
import com.znaji.accountsmicroservices.service.AccountsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toModel(customerDto);
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerExistAlreadyException("An account with this mobile number exist already: " + customer.getMobileNumber());
        }

        Customer savedCustomer = customerRepository.save(customer);

        Accounts newAccount = createNewAccount(savedCustomer);
        accountsRepository.save(newAccount);
    }

    @Override
    public CustomerDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFound("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFound("Accounts", "CustomerId", customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.toDto(customer);
        customerDto.setAccountsDto(AccountsMapper.toDto(accounts));
        return customerDto;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = new Accounts();
        long accountNumber = 1000000000L + new Random().nextInt(90000000);

        accounts.setAccountNumber(accountNumber);
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setAccountType(AccountsConstants.SAVING);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);

        return accounts;
    }
}
