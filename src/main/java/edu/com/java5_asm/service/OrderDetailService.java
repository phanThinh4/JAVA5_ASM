package edu.com.java5_asm.service;

import java.util.List;

import edu.com.java5_asm.model.Order;
import edu.com.java5_asm.model.OrderDetail;

public interface OrderDetailService {
    OrderDetail create(Order order, Integer productId);

    OrderDetail findByProductId(Integer id,Long orderId);

    OrderDetail edit(OrderDetail orderDetail, Integer productId, Integer... args);

    List<OrderDetail> findAllCart(Order order);

    void delete(Long id);
}
