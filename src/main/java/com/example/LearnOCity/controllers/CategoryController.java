package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.CategoryDTO;
import com.example.LearnOCity.dto.QuestionDTO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.Category;
import com.example.LearnOCity.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public ResultDTO createCategory(@RequestBody CategoryDTO categoryName) {
        return categoryService.create(convertToCategory(categoryName));
    }

    private Category convertToCategory(CategoryDTO categoryDTO) {
      return modelMapper.map(categoryDTO,Category.class);
    }

    @GetMapping
    public List<QuestionDTO> getCategories() {
        return null;
    }

}
