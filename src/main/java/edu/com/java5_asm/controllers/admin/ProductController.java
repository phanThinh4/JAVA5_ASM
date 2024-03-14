package edu.com.java5_asm.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.com.java5_asm.model.Product;
import edu.com.java5_asm.service.CategoryService;
import edu.com.java5_asm.service.ProductService;

@Controller
@RequestMapping("asm/admin/product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("view")
    public String viewProduct(Model model,@PageableDefault(size = 4) Pageable pageable){
        Page<Product> page = productService.findAll(pageable);

        model.addAttribute("page", page);
        return "admin/product";
    }
    @GetMapping("edit")
    public String showEditProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("isEdit", false);
        return "admin/productEdit";
    }
    @GetMapping("edit/{id}")
    public String editProduct(Model model,@PathVariable Integer id){
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("isEdit", true);


        return "admin/productEdit";
    }

}
