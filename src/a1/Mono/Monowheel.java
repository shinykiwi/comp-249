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

    public Monowheel(double weight){
        maxWeight = weight;
        this.serialNumber = counter;
        counter++;
    }

    public Monowheel(Monowheel m1){
        maxWeight = m1.maxWeight;
        this.serialNumber = counter;
        counter++;
    }


}
