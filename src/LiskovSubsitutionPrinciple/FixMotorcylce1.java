package LiskovSubsitutionPrinciple;

public class FixMotorcylce1 {
}

class FixVehicle {
    public Integer getNumberOfWheels(){
        return 2;
    }
}

class EngineVehicle extends FixVehicle{
    public Boolean hasEngine() {
        return true;
    }
}
class FixMotorcycle extends EngineVehicle{
}

class FixCar extends EngineVehicle{
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}

class FixBicycle extends FixVehicle{}


