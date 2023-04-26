package com.studentsurvey.service;

import com.studentsurvey.entity.SurveyForm;

import java.util.List;

public interface DataHandler {

    List<SurveyForm> getAllEntries();
    void addEntry(SurveyForm form);
}
