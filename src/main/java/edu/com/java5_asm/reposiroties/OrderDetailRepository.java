package edu.com.java5_asm.reposiroties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.java5_asm.model.OrderDetail;
import edu.com.java5_asm.model.Order;
import edu.com.java5_asm.model.Product;



@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{
    List<OrderDetail> findAllByOrder(Order order);
    OrderDetail findByProductAndOrder(Product product,Order order);
}
