package a1;

public class Ferry {
    protected double maxSpeed;
    protected double maxLoad;
    protected long serialNumber;
    protected static int counter = 70000;


    Ferry(){
        maxSpeed = 100;
        maxLoad = 100;
        serialNumber = counter;
        counter++;
    }
}
