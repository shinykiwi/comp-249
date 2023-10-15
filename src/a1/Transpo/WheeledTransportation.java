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

    public WheeledTransportation(int wheels, double speed){
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

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return "This " + getClass().getSimpleName() + " serial number " + serialNumber + " - has " + numberOfWheels+" wheels, has a maximum speed of " + maxSpeed+" km/hr.";

    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            WheeledTransportation w = (WheeledTransportation) o;
            if(w.numberOfWheels == numberOfWheels && w.maxSpeed == maxSpeed){
                return true;
            }

        }
        return false;
    }
}

