package com.story.backend.category.service;

import com.story.backend.category.dto.CategoryResponse;
import com.story.backend.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(CategoryResponse::of).collect(Collectors.toList());
    }
}
