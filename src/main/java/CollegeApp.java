
public class CollegeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Applicant michael = new Applicant("Michael", "Andon", 29, 3.8f, 4.0f, 2100, 25, 0);
		Application michaelsApplication = new Application(michael);

		System.out.println(michaelsApplication.runDecision());
	}

}
