package HandlingNullObj;

public class NullVehicle implements Vehicle {
    @Override
    public int getTankCapacity() {
        // adding default behavior
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        // adding default behavior
        return 0;
    }
}
