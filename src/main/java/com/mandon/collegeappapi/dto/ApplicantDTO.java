package com.mandon.collegeappapi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;

import com.mandon.collegeappapi.validations.FelonyDatesRequired;
import com.mandon.collegeappapi.validations.ValidBoolean;
import com.mandon.collegeappapi.validations.ValidScores;
import jakarta.validation.constraints.*;

@FelonyDatesRequired
@ValidScores
public class ApplicantDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @Max(value = 130, message = "Age must be less than 130")
    private int age;

    @DecimalMin(value = "0.0", message = "GPA must be at least 0.0")
    @DecimalMax(value = "4.0", message = "GPA must not exceed 4.0")
    private double gpa;

    @DecimalMin(value = "0.0", message = "GPA scale must be at least 0.0")
    @DecimalMax(value = "10.0", message = "GPA scale must not exceed 10.0")
    private double gpaScale;

    @Min(value = 0, message = "SAT score must be a non-negative integer")
    @Max(value = 1600, message = "SAT score must not exceed 1600")
    private int satScore;

    @Min(value = 0, message = "ACT score must be a non-negative integer")
    @Max(value = 36, message = "ACT score must not exceed 36")
    private int actScore;

    @ValidBoolean
    private boolean felonies;

    private List<LocalDate> felonyDates;

    @NotBlank(message = "State is required")
    private String state;

    // No-argument constructor
    public ApplicantDTO() {
    }

    // Constructor with params
    public ApplicantDTO(String firstName, String lastName, int age, double gpa,
                        double gpaScale, Integer satScore, Integer actScore,
                        boolean felonies, List<String> felonyDates, String state) {
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

    // Getters and setters

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

    public Integer getSatScore() {
        return satScore;
    }

    public void setSatScore(Integer satScore) {
        this.satScore = satScore;
    }

    public Integer getActScore() {
        return actScore;
    }

    public void setActScore(Integer actScore) {
        this.actScore = actScore;
    }

    public boolean isFelonies() {
        return felonies;
    }

    public void setFelonies(boolean felonies) {
        this.felonies = felonies;
    }

    public List<LocalDate> getFelonyDates() {
        return new ArrayList<>(felonyDates); // Return a copy for safety
    }

    public void setFelonyDates(List<String> felonyDates) {
        this.felonyDates = new ArrayList<>();
        if (felonyDates != null) {
            for (String felonyDate : felonyDates) {
                // Parse the date string to a LocalDate object
                try {
                    LocalDate givenDate = LocalDate.parse(felonyDate);
                    this.felonyDates.add(givenDate);
                } catch (DateTimeParseException e) {
                    // Handle parsing exception
                    throw new IllegalArgumentException("Invalid date format: " + felonyDate);
                }
            }
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
