package ElevatorDesign;

import java.util.List;

public class Building {
    List<Floor> floorList;
    Building(List<Floor> floors){
        this.floorList = floors;
    }

    public void addFloors(Floor newFloor){
        this.floorList.add(newFloor);
    }

    public void removeFloor(Floor floor){
        this.floorList.remove(floor);
    }
}
