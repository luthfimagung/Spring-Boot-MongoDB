package com.management.account.services;

import java.util.Optional;

import com.management.account.model.Account;

public interface IAccountService {
    Optional<Account> findById(Long _id_);
}
