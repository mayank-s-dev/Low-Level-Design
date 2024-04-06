package StrategyPattern.WithStrategyPattern;

import StrategyPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
