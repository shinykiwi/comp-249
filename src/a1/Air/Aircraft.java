package a1.Air;

public class Aircraft {
    protected double price;
    protected double maxElevation;
    protected long serialNumber;
    private static int counter = 1000;


    public Aircraft(){
        price = 1000;
        maxElevation = 200;
        serialNumber = counter;
        counter++;
    }

    public Aircraft(double price, double elevation){
        this.price = price;
        maxElevation = elevation;
        serialNumber = counter;
        counter++;
    }

    public Aircraft(Aircraft a1){
        price = a1.price;
        maxElevation = a1.maxElevation;
        serialNumber = counter;
        counter++;
    }


}
