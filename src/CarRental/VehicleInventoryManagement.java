package CarRental;


import CarRental.Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicleList;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicleList = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicles) {
        this.vehicleList = vehicles;
    }
}
