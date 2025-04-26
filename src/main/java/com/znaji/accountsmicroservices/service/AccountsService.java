package com.znaji.accountsmicroservices.service;

import com.znaji.accountsmicroservices.dto.CustomerDto;

public interface AccountsService {
    void createAccount(CustomerDto customerDto);
}
