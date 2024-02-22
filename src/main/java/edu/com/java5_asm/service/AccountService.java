package edu.com.java5_asm.service;


import edu.com.java5_asm.model.Account;

public interface AccountService {
    Account findByUsernameAndPassword(String username, String password);
    Account create(Account entity);
    Account findByUsername(String username);
}