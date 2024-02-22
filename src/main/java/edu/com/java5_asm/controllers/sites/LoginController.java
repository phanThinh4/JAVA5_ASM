package edu.com.java5_asm.controllers.sites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.com.java5_asm.constant.SessionAttr;
import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.service.AccountService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("asm")
public class LoginController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String form(Model model) {
        model.addAttribute("loginForm", new Account());
        return "/sites/login";
    }
    @GetMapping("/logout")
    public String doGetLogOut() {
        session.removeAttribute(SessionAttr.CURRENT_USER);
        return "redirect:/asm";
    }

    @PostMapping("/login")
    public String doPostLogin(@ModelAttribute Account loginForm,RedirectAttributes redirectAttributes) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Account account = accountService.findByUsernameAndPassword(username, password);

        if (account != null) {
            session.setAttribute(SessionAttr.CURRENT_USER, account);
            return "redirect:/asm";
        }else{
            redirectAttributes.addFlashAttribute("error", "Đăng Nhập Không Thành Công!!");
            return "redirect:/asm/login";
        }
    }
}
