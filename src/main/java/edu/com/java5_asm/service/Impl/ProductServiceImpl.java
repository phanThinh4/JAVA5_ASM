package edu.com.java5_asm.service.Impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Product;
import edu.com.java5_asm.reposiroties.ProductRepository;
import edu.com.java5_asm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Optional<Product> findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
}
