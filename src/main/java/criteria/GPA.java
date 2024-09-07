package criteria;

public class GPA {
    double gpa;
    double gpaScale;

    public GPA(double gpa, double gpaScale) {
        this.gpa = gpa;
        this.gpaScale = gpaScale;
    }

    public boolean hasGoodGPA() {
        double gpaThreshold = (90 * this.gpaScale) / 100;
        return this.gpa >= gpaThreshold;
    }

    public boolean hasBadGPA() {
        double gpaThreshold = (70 * this.gpaScale) / 100;
        return this.gpa < gpaThreshold;
    }
}
