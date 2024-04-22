package ElevatorDesign;

import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>(); // this has to be max priority queue
    }

    public void submitExternalRequest(int floor, Direction direction){
    }

    public void submitInternalRequest(int floor, Direction direction){

    }

    public void controlElevator(){

    }

}
