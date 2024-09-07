package criteria;

public class Name {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean hasMalformedName() {
        // Check if the name is at least one character long and not null
        if (this.firstName == null || this.firstName.isEmpty()) {
            return true;
        } else if (this.lastName == null || this.lastName.isEmpty()) {
            return true;
        }
        // Check if the first character is uppercase and the rest are lowercase
        boolean okFirstName = Character.isUpperCase(this.firstName.charAt(0)) && this.firstName.substring(1).equals(this.firstName.substring(1).toLowerCase());
        boolean okLastName = Character.isUpperCase(this.lastName.charAt(0)) && this.lastName.substring(1).equals(this.lastName.substring(1).toLowerCase());

        return !(okFirstName && okLastName);
    }
}
