package edu.com.java5_asm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Product;

@Service
public interface ProductService {
    Optional<Product> findById(Integer id);
    Page<Product> findAll(Pageable pageable);
}
