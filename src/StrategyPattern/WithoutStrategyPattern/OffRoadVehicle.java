package StrategyPattern.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{
    @Override
    public void drive() {
        // this function has same functionality as SportsVehicle Drive, results in code duplicate
        System.out.println("Sports Drive Capability");
    }
}
