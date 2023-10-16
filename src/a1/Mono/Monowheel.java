package a1.Mono;

import a1.Transpo.WheeledTransportation;

public class Monowheel extends WheeledTransportation {
    protected double maxWeight;

    private static int counter = 55000;

    public Monowheel(){
        maxWeight = 100;
        this.serialNumber = counter;
        counter++;

    }

    public Monowheel(double weight, int wheels, double speed){
        super(wheels, speed);
        maxWeight = weight;
        this.serialNumber = counter;
        counter++;
    }

    public Monowheel(Monowheel m1){
        maxWeight = m1.maxWeight;
        this.serialNumber = counter;
        counter++;
    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return super.toString() + "Its max weight is " + maxWeight+" kgs.";
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            Monowheel m = (Monowheel) o;
            if(super.equals(m) && m.maxWeight == maxWeight){
                return true;
            }
        }
        return false;
    }
}
