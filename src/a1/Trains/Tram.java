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

    public Tram(int year){
        yearOfCreation = year;
        this.serialNumber = counter;
        counter++;
    }

    public Tram(Tram t1){
        yearOfCreation = t1.yearOfCreation;
        this.serialNumber = counter;
        counter++;
    }
}
