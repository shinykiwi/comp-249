// -----------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Kira Fountain 40192824
// --


package a1.Boat;

public class Ferry {
    protected double maxSpeed;
    protected double maxLoad;
    protected long serialNumber;
    private static int counter = 70000;


    public Ferry(){
        maxSpeed = 100;
        maxLoad = 100;
        serialNumber = counter;
        counter++;
    }

    public Ferry(double speed, double load){
        maxSpeed = speed;
        maxLoad = load;
        serialNumber = counter;
        counter++;
    }

    public Ferry(Ferry f1){
        maxSpeed = f1.maxSpeed;
        maxLoad = f1.maxLoad;
        serialNumber = counter;
        counter++;
    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return "This " + getClass().getSimpleName() + " of serial number "+ serialNumber + " - has a max speed of " + maxSpeed + " mph/hr and a max load of "+maxLoad + " kgs.";
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            Ferry f = (Ferry) o;
            if(f.maxLoad == maxLoad && f.maxSpeed == maxSpeed){
                return true;
            }

        }
        return false;
    }
}
