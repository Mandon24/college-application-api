package criteria;

public class StandardizedTests {
    int satScore;
    int actScore;

    public StandardizedTests(int satScore, int actScore) {
        this.satScore = satScore;
        this.actScore = actScore;
    }

    public boolean qualifiableScores() {
        return this.satScore > 1920 || this.actScore > 27;
    }
}
