package edu.com.java5_asm.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("asm/admin")
public class HomeADController {
    @RequestMapping("/home")
    public String home(Model model) {
        
        return "admin/index";
    }
}
