package com.znaji.accountsmicroservices.dto;

import com.znaji.accountsmicroservices.dto.CustomerDto;
import com.znaji.accountsmicroservices.entity.Accounts;
import com.znaji.accountsmicroservices.entity.Customer;

public class CustomerMapper {

    private CustomerMapper(){}

    public static Customer toModel(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        return customer;
    }

    public static CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
}
