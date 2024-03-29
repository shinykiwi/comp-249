// -----------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Kira Fountain 40192824
// --


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

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return "This " + getClass().getSimpleName() + " of serial number #"+ serialNumber + " has a max elevation of " + maxElevation + " ft, and is priced at $"+price+".";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMaxElevation() {
        return maxElevation;
    }

    public void setMaxElevation(double maxElevation) {
        this.maxElevation = maxElevation;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            Aircraft a = (Aircraft) o;
            if(a.price == price && a.maxElevation == maxElevation){
                return true;
            }

        }
        return false;
    }

}
