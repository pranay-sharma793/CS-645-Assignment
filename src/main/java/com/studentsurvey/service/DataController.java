package com.studentsurvey.service;

import com.studentsurvey.entity.SurveyForm;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DataController {

    @GetMapping("/getall")
    @ApiOperation(value = "Get all entities", response = SurveyForm.class, responseContainer = "List")
    ResponseEntity<?> getAllEntities();

    @PostMapping("/add")
    @ApiOperation(value = "Create a new entity", response = SurveyForm.class)
    ResponseEntity<?> createEntity(@RequestBody SurveyForm form);
}
