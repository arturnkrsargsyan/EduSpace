package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Category;

public interface CategoryDAO {
    int create(Category category);


    Category getByCategoryName(String name);
}
