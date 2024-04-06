package LiskovSubsitutionPrinciple;
// if class B is subtype of class A, then we should be able to replace object of A with B without breaking the behaviour of the program
// subclass should extend the capability of parent class not narrow it down

interface Bike {
    void turnOnEngine();
    void accelerate();
}

class MotorCycle1 implements Bike{
    boolean isEngineOn;
    int speed;

    public void turnOnEngine(){
        // turn on the engine
        isEngineOn = true;
    }

    public void accelerate(){
        // increase the speed
        speed = speed + 10;
    }
}

//here Bicycle1 class narrow down the capability(turnOnEngine) of parent class, so it does not follow LiskovSubstitution.
class Bicycle1 implements Bike{
    public void turnOnEngine(){
        // turn on the engine
        throw new AssertionError("there is no engine");
    }

    public void accelerate(){
        // do something
    }
}
