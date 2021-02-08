package com.story.backend.category.dto;

import com.story.backend.category.entity.Category;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CategoryResponse implements Serializable {

    private static final long serialVersionUID = 735827262304386488L;

    private String categoryName;

    public static CategoryResponse of(Category category) {

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.categoryName = category.getName();

        return categoryResponse;
    }

}
