package edu.com.java5_asm.controllers.sites;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asm/register")
public class RegisterController {
    
    @GetMapping("")
    public String form(Model model) {
        return "/sites/register";
    }
}
