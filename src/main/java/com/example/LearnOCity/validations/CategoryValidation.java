package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.Category;
import com.example.LearnOCity.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidation implements Validator {

    private final CategoryService categoryService;

    public CategoryValidation(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<String> validate(Object object) {
        Category category = (Category) object;
        List<String> validations = new ArrayList<>();
        if (category.getName() == null) {
            validations.add("You Should enter Name of category");
        }
        if (categoryService.getByCategoryName(category.getName()) != null) {
            validations.add("This category already exist");
        }
        return validations;
    }
}
