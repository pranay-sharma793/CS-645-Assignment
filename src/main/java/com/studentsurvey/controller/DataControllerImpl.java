package com.studentsurvey.controller;

import com.studentsurvey.entity.SurveyForm;
import com.studentsurvey.service.DataController;
import com.studentsurvey.serviceImpl.DataHandlerImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "MyRestController", description = "REST endpoints for MyEntity")
public class DataControllerImpl implements DataController {

    @Autowired
    private DataHandlerImpl service;

    private SurveyForm form;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllEntities() {
        List<SurveyForm> entities = service.getAllEntries();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEntity(@RequestBody SurveyForm form) {
        service.addEntry(form);
        return new ResponseEntity<>(form, HttpStatus.CREATED);
    }
}
