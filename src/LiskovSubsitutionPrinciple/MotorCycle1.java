package LiskovSubsitutionPrinciple;

class Vehicle {
    public Integer getNumberOfWheels(){
        return 2;
    }

    public Boolean hasEngine(){
        return true;
    }
}

class Motorcycle extends Vehicle{
}

class Car extends Vehicle{
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}

class Bicycle extends Vehicle{
    @Override
    public Boolean hasEngine() {
        return null;
    }
}


