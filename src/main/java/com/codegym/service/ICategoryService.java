package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
