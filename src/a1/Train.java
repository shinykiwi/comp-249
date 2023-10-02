package a1;

public class Train extends WheeledTransportation{
    protected int numberOfVehicles;
    protected String startingStation;
    protected String destinationStation;
    protected static int counter = 10000;


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
}


