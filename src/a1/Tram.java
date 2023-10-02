package a1;

public class Tram extends Metro{

    int yearOfCreation;
    protected static int counter = 30000;

    Tram(){

        yearOfCreation = 2000;
        this.serialNumber = counter;
        counter++;

    }
}
