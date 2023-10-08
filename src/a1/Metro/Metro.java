package a1.Metro;

import a1.Trains.Train;

public class Metro extends Train {
    // Indicates the total number of stations between and including the starting
    // and destination stations

    protected int totalNumOfStops;
    private static int counter = 25000;

    public Metro(){
        totalNumOfStops = 2;
        this.serialNumber = counter;
        counter++;

    }

    public Metro(int stops){
        totalNumOfStops = stops;
        this.serialNumber = counter;
        counter++;

    }

}
