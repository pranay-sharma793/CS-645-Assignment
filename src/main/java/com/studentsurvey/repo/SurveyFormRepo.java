package com.studentsurvey.repo;

import com.studentsurvey.entity.SurveyForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyFormRepo extends CrudRepository<SurveyForm, Long> {

}
