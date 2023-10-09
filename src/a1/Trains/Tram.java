package a1.Trains;

import a1.Metro.Metro;

public class Tram extends Metro {

    protected int yearOfCreation;
    private static int counter = 30000;

    public Tram(){
        yearOfCreation = 2000;
        this.serialNumber = counter;
        counter++;

    }

    public Tram(int year,int stops, int numVehicles, String start, String dest, int wheels, double speed  ){
        super(stops, numVehicles, start, dest, wheels, speed);
        yearOfCreation = year;
        this.serialNumber = counter;
        counter++;
    }

    public Tram(Tram t1){
        yearOfCreation = t1.yearOfCreation;
        this.serialNumber = counter;
        counter++;
    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        return super.toString() + "It was created in "+yearOfCreation + ".";
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }
}
