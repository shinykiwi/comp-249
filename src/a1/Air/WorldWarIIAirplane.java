// -----------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Kira Fountain 40192824
// --


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

    public WorldWarIIAirplane(boolean engine, double price, double elevation){
        super(price, elevation);
        twinEngine = engine;
        this.serialNumber = counter;
        counter++;
    }

    public WorldWarIIAirplane(WorldWarIIAirplane ww2){
        twinEngine = ww2.twinEngine;
        this.serialNumber = counter;
        counter++;
    }

    protected int getNextSerialNumber(){
        return counter++;
    }

    public String toString(){
        if(twinEngine){
            return super.toString() + "It has a twin engine.";
        }
        return super.toString() + "It does not have a twin engine.";
    }

    public boolean isTwinEngine() {
        return twinEngine;
    }

    public void setTwinEngine(boolean twinEngine) {
        this.twinEngine = twinEngine;
    }

    public boolean equals(Object o){
        if ((o != null) && (getClass() == o.getClass())){
            WorldWarIIAirplane ww = (WorldWarIIAirplane) o;
            if(super.equals(ww) && twinEngine == ww.twinEngine){
                return true;
            }
        }
        return false;
    }
}
