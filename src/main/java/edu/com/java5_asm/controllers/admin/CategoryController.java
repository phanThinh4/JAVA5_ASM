package edu.com.java5_asm.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
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

import edu.com.java5_asm.model.Category;
import edu.com.java5_asm.service.CategoryService;

@Controller
@RequestMapping("asm/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @GetMapping("category")
    public String get(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("items", categoryService.findAll());
        model.addAttribute("selectedTab", "tab1");
        model.addAttribute("showTab", "tab1");
        return "admin/category";
    }

    @PostMapping("category")
    public String post(Model model, @RequestParam("action") String action,
            @ModelAttribute("category") Category category,
            @ModelAttribute("category") @Validated Category ac,
            BindingResult errors) {

        switch (action) {
            case "add":
                if (errors.hasErrors()) {
                    model.addAttribute("message", "Faild");

                } else {
                    categoryService.save(category);
                    model.addAttribute("message", "Add is Success");
                }
                break;
            case "update":
                if (errors.hasErrors()) {
                    model.addAttribute("message", "Faild");

                } else {
                    categoryService.save(category);
                    model.addAttribute("message", "Update is Success");
                }
                break;
            case "delete":
                if (categoryService.findById(category.getId()).isPresent()) {
                    categoryService.delete(category.getId());
                    model.addAttribute("message", "Delete is Success");
                    model.addAttribute("category", new Category());
                } else {
                    model.addAttribute("message", "CategoryId does not exist");
                }
                break;
            case "reset":
                model.addAttribute("category", new Category());
                break;
            default:
                break;
        }
        return "redirect:/asm/admin/category";
    }

    @RequestMapping("category/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("selectedTab", "tab1");
        model.addAttribute("showTab", "tab1");
        return "admin/category";
    }
}
