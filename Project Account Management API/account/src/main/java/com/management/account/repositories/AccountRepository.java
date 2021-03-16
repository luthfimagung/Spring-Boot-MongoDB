package com.management.account.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.management.account.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long>{

    void deleteByName(String name);
    boolean existsByName(String name);
	Optional<Account> findByName(String name);
    
}
