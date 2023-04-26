package com.studentsurvey.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SurveyData")
public class SurveyForm {

    @Id
    @Column(name = "Form_Id")
    private long form_id;

    @Column(name = "First_name")
    private String f_name;

    @Column(name = "Last_name")
    private String l_name;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Zipcode")
    private int zip;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;
}
