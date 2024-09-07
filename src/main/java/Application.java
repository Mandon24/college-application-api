
public class Application {
	Applicant applicant;

	Application(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public Decision runDecision(){
		// check for Instance Accept
		if(this.qualifiableAge() && this.qualifiableScores() && this.hasGoodGPA() && !this.hasFelonies() && !this.hasMalformedName()) {
			return Decision.ACCEPT;
		}
		// check for Instant Reject
		else if(this.hasFelonies() && this.hasBadGPA() && this.hasNegativeAge() && this.hasMalformedName()) {
			return Decision.REJECT;
		}

		// check for Further Review
		return Decision.REVIEW;
	}

	public boolean qualifiableAge() {
		if((this.applicant.age > 17 && this.applicant.age < 26) || this.applicant.age > 80) {
			return true;
		}
		return false;
	}

	public boolean qualifiableScores() {
		if(this.applicant.satScore > 1920 || this.applicant.actScore > 27) {
			return true;
		}
		return false;
	}

	public boolean hasGoodGPA() {
		float gpaThreshold = (90 * this.applicant.gpaScale) / 100;
		if(this.applicant.gpa >= gpaThreshold) {
			return true;
		}
		return false;
	}

	public boolean hasBadGPA() {
		float gpaThreshold = (70 * this.applicant.gpaScale) / 100;
		if(this.applicant.gpa < gpaThreshold) {
			return true;
		}
		return false;
	}
	

	public boolean hasFelonies() {
		if(this.applicant.felonies >= 1) {
			return true;
		}
		return false;
	}

	public boolean hasNegativeAge() {
		if(this.applicant.age < 0) {
			return true;
		}
		return false;
	}

	public boolean hasMalformedName() {
        // Check if the name is at least one character long and not null
        if (this.applicant.firstName == null || this.applicant.firstName.isEmpty()) {
            return true;
        }
        else if (this.applicant.lastName == null || this.applicant.lastName.isEmpty()) {
            return true;
        }
        // Check if the first character is uppercase and the rest are lowercase
        boolean okFirstName = Character.isUpperCase(this.applicant.firstName.charAt(0)) && this.applicant.firstName.substring(1).equals(this.applicant.firstName.substring(1).toLowerCase());
        boolean okLastName = Character.isUpperCase(this.applicant.lastName.charAt(0)) && this.applicant.lastName.substring(1).equals(this.applicant.lastName.substring(1).toLowerCase());
        
        return !(okFirstName && okLastName);
    }

}
