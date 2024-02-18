package edu.com.java5_asm.service;

import java.util.List;
import java.util.Optional;

import edu.com.java5_asm.model.Category;

public interface CategoryService {

    void delete(Category entity);

    List<Category> findAll();

    List<Category> findAllById(Iterable<String> ids);

    Optional<Category> findById(String id);

    <S extends Category> List<S> saveAll(Iterable<S> entities);

}