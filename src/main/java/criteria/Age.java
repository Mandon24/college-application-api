package criteria;

import models.State;

public class Age {
    int age;
    String state;

    public Age(int age, String state) {
        this.age = age;
        this.state = state;
    }

    public boolean qualifiableAge() {
        if (this.state.equalsIgnoreCase(State.CALIFORINA.name())) {
            return (this.age > 17 && this.age < 26) || this.age > 80;
        } else {
            return this.age > 80;
        }

    }

    public boolean hasNegativeAge() {
        return this.age < 0;
    }
}
