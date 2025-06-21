package ElevatorDesign;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorController> elevatorControllersList = ElevatorCreator.elevatorControllers;

    public void SubmitExternalRequest(int floor, Direction direction){
        for(ElevatorController elevatorController : elevatorControllersList) {

            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }
    }


}
