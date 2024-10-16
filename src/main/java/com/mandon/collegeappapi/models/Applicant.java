package com.mandon.collegeappapi.models;

import com.mandon.collegeappapi.dto.ApplicantDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Applicant {
    String firstName;
    String lastName;
    int age;
    double gpa;
    double gpaScale;
    int satScore;
    int actScore;
    boolean felonies;
    List<LocalDate> felonyDates;
    String state;

    public Applicant(String firstName, String lastName, int age, double gpa, double gpaScale, int satScore, int actScore, boolean felonies, List<LocalDate> felonyDates, String state) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGpa(gpa);
        setGpaScale(gpaScale);
        setSatScore(satScore);
        setActScore(actScore);
        setFelonies(felonies);
        setFelonyDates(felonyDates);
        setState(state);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpaScale() {
        return gpaScale;
    }

    public void setGpaScale(double gpaScale) {
        this.gpaScale = gpaScale;
    }

    public int getSatScore() {
        return satScore;
    }

    public void setSatScore(int satScore) {
        this.satScore = satScore;
    }

    public int getActScore() {
        return actScore;
    }

    public void setActScore(int actScore) {
        this.actScore = actScore;
    }

    public boolean getFelonies() {
        return felonies;
    }

    public void setFelonies(boolean felonies) {
        this.felonies = felonies;
    }

    public List<LocalDate> getFelonyDates() {
        return felonyDates;
    }

    public void setFelonyDates(List<LocalDate> felonyDates) {
        this.felonyDates = felonyDates;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Conversion method from ApplicantDTO to Applicant
    public static Applicant fromDTO(ApplicantDTO dto) {
        return new Applicant(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge(),
                dto.getGpa(),
                dto.getGpaScale(),
                dto.getSatScore(),
                dto.getActScore(),
                dto.isFelonies(),
                dto.getFelonyDates(),
                dto.getState()
        );
    }
}
