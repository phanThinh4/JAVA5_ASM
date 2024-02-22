package edu.com.java5_asm.controllers.sites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.com.java5_asm.constant.SessionAttr;
import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.service.AccountService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/asm")
public class RegisterController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("registerForm", new Account());
        return "/sites/register";
    }

    @PostMapping("/register")
    public String doPostRegister(@ModelAttribute Account registerForm,RedirectAttributes redirectAttributes) {
        Account account = accountService.findByUsername(registerForm.getUsername());
        if (account == null) {
            accountService.create(registerForm);
            session.setAttribute(SessionAttr.CURRENT_USER, registerForm);
            return "redirect:/asm";
        }else{
            redirectAttributes.addFlashAttribute("error", "Đăng Ký Không Thành Công!!");
            return "redirect:/asm/register";
        }
    }
}
