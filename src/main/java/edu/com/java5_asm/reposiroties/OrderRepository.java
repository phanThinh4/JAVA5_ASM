package edu.com.java5_asm.reposiroties;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.com.java5_asm.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
