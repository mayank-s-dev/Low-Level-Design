package HandlingNullObj;


public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(vehicle);
        Vehicle vehicle1 = VehicleFactory.getVehicleObject("Car");
        printVehicleDetails(vehicle1);
    }

    public static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating capacity:" + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity:" + vehicle.getTankCapacity());
    }

    // below two function are not related to rest of the package, they just demonstrate if check for null object
    public static void Wrong_printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating capacity:" + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity:" + vehicle.getTankCapacity());
    }

    public static void Correct_printVehicleDetails(Vehicle vehicle) {
        if (vehicle != null) {
            // this will work for small project or a file, but we should avoid it for a big project
            System.out.println("Seating capacity:" + vehicle.getSeatingCapacity());
            System.out.println("Tank Capacity:" + vehicle.getTankCapacity());
        }
    }
}
