package edu.com.java5_asm.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.com.java5_asm.model.Category;
import edu.com.java5_asm.reposiroties.CategoryRepository;
import edu.com.java5_asm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllById(Iterable<String> ids) {
        return categoryRepository.findAllById(ids);
    }

    @Override
    public Optional<Category> findById(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public <S extends Category> List<S> saveAll(Iterable<S> entities) {
        return categoryRepository.saveAll(entities);
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    
    
}
