package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.QuestionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
   @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCategory(@RequestBody QuestionDTO questionDTO){
       return null;
   }
   @GetMapping
    public List<QuestionDTO> getCategories() {
       return null;
   }

}
