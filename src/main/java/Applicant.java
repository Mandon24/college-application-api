
public class Applicant {
	String firstName;
	String lastName;
	int age;
	float gpa;
	float gpaScale;
	int satScore;
	int actScore;
	int felonies;
	

	Applicant(String firstName, String lastName, int age, float gpa, float gpaScale, int satScore, int actScore, int felonies){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gpa = gpa;
		this.gpaScale = gpaScale;
		this.satScore = satScore;
		this.actScore = actScore;
		this.felonies = felonies;
	}
}
