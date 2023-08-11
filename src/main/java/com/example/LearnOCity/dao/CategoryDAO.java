package com.example.LearnOCity.dao;

import com.example.LearnOCity.dto.CategoryDTO;
import com.example.LearnOCity.models.Category;

import java.util.List;

public interface CategoryDAO {
    int create(Category category);


    Category getByCategoryName(String name);
}
