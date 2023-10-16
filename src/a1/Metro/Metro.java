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

    public Metro(int stops, int numVehicles, String start, String dest, int wheels, double speed ){
        super(numVehicles, start, dest, wheels, speed);
        totalNumOfStops = stops;
        this.serialNumber = counter;
        counter++;

    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return super.toString() + "It has " + totalNumOfStops + " total stops.";
    }

    public int getTotalNumOfStops() {
        return totalNumOfStops;
    }

    public void setTotalNumOfStops(int totalNumOfStops) {
        this.totalNumOfStops = totalNumOfStops;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            Metro m = (Metro) o;
            if(super.equals(m) && m.totalNumOfStops == totalNumOfStops){
                return true;
            }
        }
        return false;
    }


}
