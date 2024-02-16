package edu.com.java5_asm.reposiroties;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.com.java5_asm.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{
    
}
