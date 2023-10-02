package a1;

public class Monowheel extends WheeledTransportation{
    double maxWeight;

    static int counter = 55000;

    Monowheel(){
        maxWeight = 100;
        this.serialNumber = counter;
        counter++;



    }
}
