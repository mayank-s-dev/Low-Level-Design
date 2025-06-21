package HandlingNullObj;

public class VehicleFactory {
    public static Vehicle getVehicleObject(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        }

        // without this null object pattern, we used to return
        // return null
        return new NullVehicle();
    }
}
