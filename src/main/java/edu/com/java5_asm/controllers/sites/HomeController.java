package edu.com.java5_asm.controllers.sites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.com.java5_asm.model.Category;
import edu.com.java5_asm.model.Product;
import edu.com.java5_asm.reposiroties.CategoryRepository;
import edu.com.java5_asm.reposiroties.ProductRepository;


@Controller
@RequestMapping("asm")
public class HomeController {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public String form(Model model) {
        List<Product> products = repository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("items", products);
        return "/sites/index";
    }
    
    @GetMapping("/{p}")
    public String productFilter(Model model,@PathVariable("p") String id) {
        if(id.equals("1")){
            List<Product> products = repository.findAll();
            model.addAttribute("items", products);
        }else{
            List<Product> products = repository.findByCategoryID(id);
            model.addAttribute("items", products);
        }
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        
        return "/sites/index";
    }
}
