package a1;

public class Train extends WheeledTransportation{
    int numberOfVehicles;
    String startingStation;
    String destinationStation;
    static int counter = 10000;


    public Train(){
        numberOfVehicles = 1;
        startingStation = "Montreal";
        destinationStation = "Ottawa";
        counter++;
        super.serialNumber = counter;
    }

    public Train(int numVehicles, String start, String dest){
        numberOfVehicles = numVehicles;
        startingStation = start;
        destinationStation = dest;
        counter++;
        super.serialNumber = counter;
    }
}


