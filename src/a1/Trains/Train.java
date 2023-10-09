package a1.Trains;

import a1.Transpo.WheeledTransportation;

public class Train extends WheeledTransportation {
    protected int numberOfVehicles;
    protected String startingStation;
    protected String destinationStation;
    private static int counter = 10000;


    public Train(){
        numberOfVehicles = 1;
        startingStation = "Montreal";
        destinationStation = "Ottawa";
        super.serialNumber = counter;
        counter++;
    }

    public Train(int numVehicles, String start, String dest, int wheels, double speed){
        super(wheels, speed);
        numberOfVehicles = numVehicles;
        startingStation = start;
        destinationStation = dest;
        super.serialNumber = counter;
        counter++;
    }

    public Train(Train t1){
        numberOfVehicles = t1.numberOfVehicles;
        startingStation = t1.startingStation;
        destinationStation = t1.destinationStation;
        super.serialNumber = counter;
        counter++;
    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return super.toString() + "It has " + numberOfVehicles + " vehicles and its starting and destination stations are "+ startingStation + " and "+destinationStation+".";

    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }
}


