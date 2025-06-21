package StrategyPattern.WithStrategyPattern.Strategy;

public class SportsDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("This is special drive capability");
    }
}