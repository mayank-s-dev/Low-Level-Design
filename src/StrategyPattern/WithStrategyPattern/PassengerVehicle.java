package StrategyPattern.WithStrategyPattern;

import StrategyPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle(){
        super(new NormalDriveStrategy());
    }

    public static class Main {
    }
}
