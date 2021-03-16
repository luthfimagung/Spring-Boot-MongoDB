package com.management.account.services;

import java.util.Optional;

import com.management.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.account.model.Account;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<Account> findById(Long _id_) {
        return accountRepository.findById(_id_);
    }
}
