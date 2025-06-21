package ElevatorDesign;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floor){
        this.floorNumber = floor;
        this.externalDispatcher = new ExternalDispatcher();
    }
}
