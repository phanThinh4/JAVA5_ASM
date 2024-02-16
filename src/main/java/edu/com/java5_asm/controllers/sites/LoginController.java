package edu.com.java5_asm.controllers.sites;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("login")
public class LoginController {
    
    @GetMapping("")
    public String form(Model model) {
        return "/sites/login";
    }
    
}
