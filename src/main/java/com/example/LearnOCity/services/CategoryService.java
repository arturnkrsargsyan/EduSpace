package com.example.LearnOCity.services;

import com.example.LearnOCity.dto.CategoryDTO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    ResultDTO create(Category category);
    List<CategoryDTO> getAllCategories();

    Category getByCategoryName(String name);
}
