package com.studentsurvey.serviceImpl;

import com.studentsurvey.entity.SurveyForm;
import com.studentsurvey.repo.SurveyFormRepo;
import com.studentsurvey.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataHandlerImpl implements DataHandler {

    private SurveyForm form = new SurveyForm();

    @Autowired
    private SurveyFormRepo surveyFormRepo;

    public List<SurveyForm> getAllEntries(){
        return (List<SurveyForm>) surveyFormRepo.findAll();
    }

    public void addEntry(SurveyForm form){
        surveyFormRepo.save(form);
    }

}
