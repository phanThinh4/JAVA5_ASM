package edu.com.java5_asm.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Order;
import edu.com.java5_asm.model.OrderDetail;
import edu.com.java5_asm.model.Product;
import edu.com.java5_asm.reposiroties.OrderDetailRepository;
import edu.com.java5_asm.service.OrderDetailService;
import edu.com.java5_asm.service.OrderService;
import edu.com.java5_asm.service.ProductService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail create(Order order, Integer productID) {
        OrderDetail itemCart = new OrderDetail();
        Optional<Product> product = productService.findById(productID);
        if (product != null) {
            itemCart.setQuantily(1);
            itemCart.setPrice(product.get().getPrice());
            itemCart.setOrder(order);
            itemCart.setProduct(product.get());
            orderDetailRepository.save(itemCart);
        }
        return itemCart;
    }

    @Override
    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> findAllCart(Order order) {
        return orderDetailRepository.findAllByOrder(order);
    }

    @Override
    public OrderDetail findByProductId(Integer id,Long orderId) {
        OrderDetail itemCart = new OrderDetail();
        Optional<Product> product = productService.findById(id);
        Optional<Order> order = orderService.findById(orderId);
        if (product != null) {
            itemCart = orderDetailRepository.findByProductAndOrder(product.get(),order.get());
        }
        return itemCart;
    }

    @Override
    public OrderDetail edit(OrderDetail orderDetail, Integer productId, Integer... args) {
        Optional<Product> product = productService.findById(productId);
        if (product != null) {
            if (args != null && args.length > 0) {
                orderDetail.setQuantily(args[0]);
            } else {
                orderDetail.setQuantily(orderDetail.getQuantily() + 1);
            }
            orderDetail.setPrice(product.get().getPrice() * orderDetail.getQuantily());
            orderDetailRepository.save(orderDetail);
        }
        return orderDetail;
    }

}
