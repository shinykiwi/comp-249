package a1.Transpo;

import a1.Air.Aircraft;
import a1.Air.WorldWarIIAirplane;
import a1.Metro.Metro;

public class Main {

    public static void main(String[] args) {
        Aircraft a1 = new Aircraft();
        Aircraft a2 = new Aircraft();
        WorldWarIIAirplane ww2 = new WorldWarIIAirplane();
        WorldWarIIAirplane ww3 = new WorldWarIIAirplane();

        Metro m1 = new Metro();

        System.out.println(a1.equals(a2)); // true

        System.out.println(a1.equals(m1)); // false

        System.out.println(ww2.equals(ww3)); // true



    }

    public static void findLeastAndMostExpensiveAircraft(){

    }
}
