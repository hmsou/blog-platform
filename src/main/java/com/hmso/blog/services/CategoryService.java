package com.hmso.blog.services;

import com.hmso.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
