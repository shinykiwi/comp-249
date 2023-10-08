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

    public Train(int numVehicles, String start, String dest){
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


}


