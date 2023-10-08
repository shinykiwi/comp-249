package a1.Air;

import a1.Air.Aircraft;

public class WorldWarIIAirplane extends Aircraft {

    protected boolean twinEngine;
    private static int counter = 80000;

    public WorldWarIIAirplane(){
        twinEngine = false;
        this.serialNumber = counter;
        counter++;
    }

    public WorldWarIIAirplane(boolean engine){
        twinEngine = engine;
        this.serialNumber = counter;
        counter++;
    }

    public WorldWarIIAirplane(WorldWarIIAirplane ww2){
        twinEngine = ww2.twinEngine;
        this.serialNumber = counter;
        counter++;
    }

}
