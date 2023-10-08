package a1.Transpo;

public class WheeledTransportation {
    protected int numberOfWheels;
    protected double maxSpeed;
    protected long serialNumber;
    private static int counter = 0;

    public WheeledTransportation(){
        numberOfWheels = 4;
        maxSpeed = 120;
        serialNumber = counter;
        counter++;
    }

    public WheeledTransportation(int wheels, double speed, long serialNumber){
        numberOfWheels = wheels;
        maxSpeed = speed;
        this.serialNumber = counter;
        counter++;
    }

    public WheeledTransportation(WheeledTransportation w1){
        numberOfWheels = w1.numberOfWheels;
        maxSpeed = w1.maxSpeed;
        serialNumber = counter;
        counter++;

    }

}

