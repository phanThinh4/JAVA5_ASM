package edu.com.java5_asm.controllers.sites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.com.java5_asm.constant.SessionAttr;
import edu.com.java5_asm.model.Account;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("asm")
public class CartController {
    @Autowired
    HttpSession session;

    @GetMapping("/cart")
    public String form(Model model) {
        Account account = (Account) session.getAttribute(SessionAttr.CURRENT_USER);
        if (account == null) {
            return "redirect:/asm/login";
        }
        return "/sites/cart";
    }
}
