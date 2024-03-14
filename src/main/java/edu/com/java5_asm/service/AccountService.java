package edu.com.java5_asm.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.com.java5_asm.model.Account;

public interface AccountService {
    Account findByUsernameAndPassword(String username, String password);
    Account create(Account entity);
    Account findByUsername(String username);
    Page<Account> findAll(Pageable pageable);
    Page<Account> findByKeywords(String key,Pageable pageable);
    Account saveAccount(Account entity);
    void deleteByUsername(String username);
}