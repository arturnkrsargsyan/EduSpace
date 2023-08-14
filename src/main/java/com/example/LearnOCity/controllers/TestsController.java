package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.QuestionDTO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.dto.TestDTO;
import com.example.LearnOCity.models.Question;
import com.example.LearnOCity.models.Test;
import com.example.LearnOCity.services.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/tests")
public class TestsController {

    private final TestService testService;
    private final ModelMapper modelMapper;

    public TestsController(TestService testService, ModelMapper modelMapper) {
        this.testService = testService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<TestDTO> getAll() {
        return this.testService.getAll().stream().map(this::convertToTestDTO).collect(Collectors.toList());
    }

    @PostMapping("/{testId}/check")
    public double check(@PathVariable("testId") int testId, @RequestBody Map<Integer, Integer> map) {
        return testService.check(testId, map);
    }

    @GetMapping("/{id}/by-criteria")
    public List<QuestionDTO> getByCount(@PathVariable("id") int id, @RequestParam("count") int count) {
        return this.testService.getByCount(id, count).stream().map(this::convertDtoToQuestions).collect(Collectors.toList());
    }

    @PostMapping
    public ResultDTO save(@RequestBody TestDTO testDTO) {
        return this.testService.save(convertDtoToTest(testDTO));
    }

    private Test convertDtoToTest(TestDTO testDTO) {
        return modelMapper.map(testDTO, Test.class);
    }

    private QuestionDTO convertDtoToQuestions(Question question) {
        return modelMapper.map(question, QuestionDTO.class);
    }

    private TestDTO convertToTestDTO(Test test) {
        return modelMapper.map(test, TestDTO.class);
    }
}
