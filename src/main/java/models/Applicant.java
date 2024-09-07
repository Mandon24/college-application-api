package models;

public class Applicant {
    String firstName;
    String lastName;
    int age;
    double gpa;
    double gpaScale;
    int satScore;
    int actScore;
    int felonies;
    String state;

    public Applicant(String firstName, String lastName, int age, double gpa, double gpaScale, int satScore, int actScore, int felonies, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
        this.gpaScale = gpaScale;
        this.satScore = satScore;
        this.actScore = actScore;
        this.felonies = felonies;
        this.state = state;
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

    public int getFelonies() {
        return felonies;
    }

    public void setFelonies(int felonies) {
        this.felonies = felonies;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
