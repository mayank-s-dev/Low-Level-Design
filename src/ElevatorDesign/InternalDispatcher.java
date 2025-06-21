package ElevatorDesign;

import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllers;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        for(ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID%2==1 && floor%2==1){
//                elevatorController.submitInternalRequest(floor);
            } else if(elevatorID%2==0 && floor%2==0){
//                elevatorController.submitInternalRequest(floor);

            }
        }

    }
}
