package edu.com.java5_asm.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.model.Order;
import edu.com.java5_asm.reposiroties.OrderRepository;
import edu.com.java5_asm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Account account) {
        Order newOrder = new Order();
        newOrder.setAccount(account);
        newOrder.setAddress("");
        newOrder.setCreateDate(new Date());
        newOrder.setCheckOut(false);
        newOrder.setStatus(false);
        orderRepository.save(newOrder);
        return newOrder;
    }

    @Override
    public void delete(Account account) {
        orderRepository.delete(account.getOrders().get(0));
    }

    @Override
    public Order findByAcount(Account account) {
        List<Order> lsOrders = orderRepository.findByAccount(account);
        for (Order orderOld : lsOrders) {
            if(!orderOld.isCheckOut()){
                return orderOld;
            }
        }
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
