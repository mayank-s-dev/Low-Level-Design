package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    static List<ElevatorController> elevatorControllers = new ArrayList<>();
    static {
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.id = 1;
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);
        elevatorControllers.add(elevatorController1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.id = 1;
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar1);
        elevatorControllers.add(elevatorController2);


    }
}
