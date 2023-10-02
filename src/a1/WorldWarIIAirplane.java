package a1;

public class WorldWarIIAirplane extends Aircraft{

    boolean twinEngine;
    static int counter = 80000;

    WorldWarIIAirplane(){
        this.serialNumber = counter;
        counter++;
    }
}
