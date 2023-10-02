package a1;

public class Metro extends Train{
    // Indicates the total number of stations between and including the starting
    // and destination stations

    protected int totalNumOfStops;
    protected static int counter = 25000;

    public Metro(){
        totalNumOfStops = 2;
        this.serialNumber = counter;
        counter++;

    }

}
