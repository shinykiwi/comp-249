package a1.Boat;

public class Ferry {
    protected double maxSpeed;
    protected double maxLoad;
    protected long serialNumber;
    private static int counter = 70000;


    public Ferry(){
        maxSpeed = 100;
        maxLoad = 100;
        serialNumber = counter;
        counter++;
    }

    public Ferry(double speed, double load){
        maxSpeed = speed;
        maxLoad = load;
        serialNumber = counter;
        counter++;
    }

    public Ferry(Ferry f1){
        maxSpeed = f1.maxSpeed;
        maxLoad = f1.maxLoad;
        serialNumber = counter;
        counter++;
    }


}
