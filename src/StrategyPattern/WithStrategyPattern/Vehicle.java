package StrategyPattern.WithStrategyPattern;

import StrategyPattern.WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    private final DriveStrategy driveStrategyObj;

    // we won't do like below, because we want our drive strategy to be dynamic
    //    DriveStrategy driveStrategyObj = new NormalDriveStrategy();

    // this is constructor injection
    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategyObj = driveStrategy;
    }

    public void drive(){
        driveStrategyObj.drive();
    }
}

