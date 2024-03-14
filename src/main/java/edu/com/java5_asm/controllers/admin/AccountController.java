package edu.com.java5_asm.controllers.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.com.java5_asm.constant.SessionAttr;
import edu.com.java5_asm.model.Account;
import edu.com.java5_asm.service.AccountService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("asm/admin")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession session;

    @GetMapping("account")
    public String home(Model model) {
        
        model.addAttribute("account", new Account());

        Pageable pageable = PageRequest.of(0, 2);
        Page<Account> page = accountService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("selectedTab", "tab1");
        model.addAttribute("showTab", "tab1");
        return "admin/account";
    }
    @PostMapping("account")
    public String postAccount(Model model, @RequestParam("action") String action,
            @ModelAttribute("account") Account account,
            @ModelAttribute("account") @Validated Account ac,
            BindingResult errors) {

        switch (action) {
            case "add":
                if (errors.hasErrors()) {
                    model.addAttribute("message", "Faild");

                } else {
                    accountService.saveAccount(account);
                    model.addAttribute("account", new Account());
                    model.addAttribute("message", "Add is Success");
                }
                break;
            case "update":
                if (errors.hasErrors()) {
                    model.addAttribute("message", "Faild");

                } else {
                    accountService.saveAccount(account);
                    model.addAttribute("account", new Account());
                    model.addAttribute("message", "Update is Success");
                }
                break;
            case "delete":
                if (accountService.findByUsername(account.getUsername()) != null) {
                    accountService.deleteByUsername(account.getUsername());
                    model.addAttribute("message", "Delete is Success");
                } else {
                    model.addAttribute("message", "Username does not exist");
                }
                break;
            case "reset":
                model.addAttribute("account", new Account());
                break;
            default:
                break;
        }
        Pageable pageable = PageRequest.of(0, 2);
        Page<Account> page = accountService.findAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("selectedTab", "tab1");
        model.addAttribute("showTab", "tab1");
        return "admin/account";
    }

    @RequestMapping("account/edit/{name}")
    public String edit(Model model, @PathVariable("name") String name) {
        Account account = accountService.findByUsername(name);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Account> page = accountService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("account", account);
        model.addAttribute("selectedTab", "tab1");
        model.addAttribute("showTab", "tab1");
        return "admin/account";
    }

    @RequestMapping("account/pageable")
    public String pageAccount(Model model, @RequestParam("key") Optional<String> key,
            @RequestParam("p") Optional<Integer> p) {

        String kwords = key.orElse("");
        Pageable pageable = PageRequest.of(p.orElse(0), 2);
        if (key.isPresent()) {
            session.setAttribute("key", kwords);
            Page<Account> page = accountService.findByKeywords("%" + kwords + "%", pageable);
            model.addAttribute("page", page);
        } else {
            Page<Account> page = accountService.findAll(pageable);
            model.addAttribute("page", page);
        }
        Account account = (Account) session.getAttribute(SessionAttr.CURRENT_USER);
        model.addAttribute("account", account);
        model.addAttribute("selectedTab", "tab2");
        model.addAttribute("showTab", "tab2");
        return "admin/account";
    }
}
