package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.TestAnswerCheckDTO;
import com.example.LearnOCity.dto.TestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/tests")
public class TestsController {
    @GetMapping
    public List<TestDTO> getAll(){
        return null;
    }
    @PostMapping("/{id}/check")
    public List<TestAnswerCheckDTO> check(@PathVariable("id")int id, @RequestBody Map<Integer,Integer> list){
        return null;
    }

}
