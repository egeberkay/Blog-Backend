package com.egeberkayyesil.blog.services;

import com.egeberkayyesil.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
