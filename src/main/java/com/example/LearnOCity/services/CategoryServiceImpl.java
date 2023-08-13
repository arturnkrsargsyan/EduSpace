package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.CategoryDAO;
import com.example.LearnOCity.dto.CategoryDTO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.Category;
import com.example.LearnOCity.validations.CategoryValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;
    private final CategoryValidation categoryValidation;

    public CategoryServiceImpl(CategoryDAO categoryDAO, CategoryValidation categoryValidation) {
        this.categoryDAO = categoryDAO;
        this.categoryValidation = categoryValidation;
    }

    @Override
    public ResultDTO create(Category category) {
        ResultDTO resultDTO = new ResultDTO();
        categoryValidation.validate(category);
        if (resultDTO.getValidations().isEmpty()){
            category.setId(categoryDAO.create(category));
            resultDTO.setSuccess(true);
        }
        return resultDTO;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
       List<CategoryDTO> allCategories = new ArrayList<>();
        return allCategories;
    }

    @Override
    public Category getByCategoryName(String name) {
        return categoryDAO.getByCategoryName(name);
    }

}
