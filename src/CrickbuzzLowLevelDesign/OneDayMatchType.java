package CrickbuzzLowLevelDesign;

public class OneDayMatchType implements MatchType {
    @Override
    public int numberOfOvers() {
        return 50;
    }

    @Override
    public int maxOverPerBowler() {
        return 10;
    }
}
