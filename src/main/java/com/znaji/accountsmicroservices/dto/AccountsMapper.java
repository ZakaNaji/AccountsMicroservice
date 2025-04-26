package com.znaji.accountsmicroservices.dto;

import com.znaji.accountsmicroservices.entity.Accounts;

public class AccountsMapper {

    private AccountsMapper(){}
    public static AccountsDto toDto(Accounts accounts) {
        AccountsDto dto = new AccountsDto();
        dto.setAccountNumber(accounts.getAccountNumber());
        dto.setAccountType(accounts.getAccountType());
        dto.setBranchAddress(accounts.getBranchAddress());
        return dto;
    }
}
