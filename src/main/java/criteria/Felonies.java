package criteria;

import models.Decision;
import models.Results;

public class Felonies {
    int felonies;

    public Felonies(int felonies) {
        this.felonies = felonies;
    }

    public Results hasFelonies() {
        if (this.felonies >= 1) {
            return new Results(String.format("%d felonies found", this.felonies), Decision.REJECT);
        }
        return new Results("", Decision.ACCEPT);
    }
}
