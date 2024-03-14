package edu.com.java5_asm.reposiroties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    List<Order> findByAccount(Account account);
}
