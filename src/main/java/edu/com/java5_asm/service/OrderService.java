package edu.com.java5_asm.service;

import java.util.Optional;

import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.model.Order;

public interface OrderService {
    Order create(Account account);
    void delete(Account account);
    Order findByAcount(Account account);
    Optional<Order> findById(Long id);
}
