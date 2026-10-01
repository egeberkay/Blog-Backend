package com.egeberkayyesil.blog.services.impl;

import com.egeberkayyesil.blog.domain.entities.Category;
import com.egeberkayyesil.blog.repositories.CategoryRepository;
import com.egeberkayyesil.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}