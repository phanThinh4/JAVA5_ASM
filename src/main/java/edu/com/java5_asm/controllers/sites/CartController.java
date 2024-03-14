package edu.com.java5_asm.controllers.sites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.com.java5_asm.constant.SessionAttr;
import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.model.Order;
import edu.com.java5_asm.model.OrderDetail;
import edu.com.java5_asm.service.OrderDetailService;
import edu.com.java5_asm.service.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("asm")
public class CartController {
    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/cart")
    public String form(Model model) {
        Account account = (Account) session.getAttribute(SessionAttr.CURRENT_USER);
        if (account == null) {
            return "redirect:/asm/login";
        }
        Order order = orderService.findByAcount(account);
        if (order == null) {
            model.addAttribute("items", null);
        } else {
            List<OrderDetail> ls = orderDetailService.findAllCart(order);
            model.addAttribute("items", ls);
            double totalPrice = 0;
            for (OrderDetail orderDetail : ls) {
                totalPrice += orderDetail.getPrice();
            }
            model.addAttribute("totalPrice", totalPrice);
        }
        return "/sites/cart";
    }

    @GetMapping("/cart/{p}")
    public String addToCart(Model model, @PathVariable("p") Integer idProduct) {
        Account account = (Account) session.getAttribute(SessionAttr.CURRENT_USER);
        if (account == null) {
            return "redirect:/asm/login";
        }
        Order order = orderService.findByAcount(account);
        if (order == null) {
            order = orderService.create(account);
            orderDetailService.create(order, idProduct);
        }
        OrderDetail orderDetail = orderDetailService.findByProductId(idProduct, order.getId());
        if (orderDetail != null) {
            orderDetailService.edit(orderDetail, idProduct);
        } else {
            orderDetailService.create(order, idProduct);
        }
        model.addAttribute("items", orderDetailService.findAllCart(order));

        return "redirect:/asm/cart";
    }

    @RequestMapping("/cart/edit/{id}")
    public String update(@PathVariable("id") Integer id,
            @RequestParam("qty") Integer qty) {
        Account account = (Account) session.getAttribute(SessionAttr.CURRENT_USER);
        Order order = orderService.findByAcount(account);
        OrderDetail orderDetail = orderDetailService.findByProductId(id, order.getId());
        if (orderDetail != null) {
            orderDetailService.edit(orderDetail, id, qty);
        }
        return "redirect:/asm/cart";
    }

    @RequestMapping("/delete/{p}")
    public String deleteItemCart(Model model, @PathVariable("p") Long idItemCart) {
        orderDetailService.delete(idItemCart);
        return "redirect:/asm/cart";
    }
}
