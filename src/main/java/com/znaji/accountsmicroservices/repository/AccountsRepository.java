package com.znaji.accountsmicroservices.repository;

import com.znaji.accountsmicroservices.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
