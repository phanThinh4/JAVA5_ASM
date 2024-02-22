package edu.com.java5_asm.service.Impl;


import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.reposiroties.AccountRepository;
import edu.com.java5_asm.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Account create(Account newAccount) {
        newAccount.setPhoto("");
        newAccount.setActivated(true);
        newAccount.setAdmin(false);
        newAccount.setOrders(null);
        accountRepository.save(newAccount);
        return newAccount;
    }

    @Override
    public Account findByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return account;
    }
    
}
