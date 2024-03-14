package edu.com.java5_asm.service;

import java.util.List;
import java.util.Optional;

import edu.com.java5_asm.model.Category;

public interface CategoryService {

    void delete(String id);

    List<Category> findAll();

    List<Category> findAllById(Iterable<String> ids);

    Optional<Category> findById(String id);

    <S extends Category> List<S> saveAll(Iterable<S> entities);

    Category save(Category category);
}