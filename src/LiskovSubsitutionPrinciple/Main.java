package LiskovSubsitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

// testing liskov after fixing
public class Main {
    public static void main(String args[]){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Motorcycle());
        vehicleList.add(new Car());
        for(Vehicle vehicle: vehicleList){
//        vehicleList.add(new Bicycle1()); ## this will return null pointer exception during runtime
            System.out.println(vehicle.hasEngine().toString());
        }


        List<EngineVehicle> engineVehicleList = new ArrayList<>();
        engineVehicleList.add(new FixMotorcycle());
        engineVehicleList.add(new FixCar());

        // below is giving compile time exception
//        engineVehicleList.add(new FixBicycle());
        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}
