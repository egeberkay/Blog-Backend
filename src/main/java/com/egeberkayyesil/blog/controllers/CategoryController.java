package com.egeberkayyesil.blog.controllers;

import com.egeberkayyesil.blog.domain.dto.CategoryDto;
import com.egeberkayyesil.blog.domain.entities.Category;
import com.egeberkayyesil.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<Category> categories = categoryService.listCategories();
        return categories;
    }
}