// -----------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Kira Fountain 40192824
// --


package a1.Transpo;

import a1.Air.Aircraft;
import a1.Air.WorldWarIIAirplane;
import a1.Boat.Ferry;
import a1.Metro.Metro;

public class Main {

    public static void main(String[] args) {
        Aircraft a1 = new Aircraft();
        Aircraft a2 = new Aircraft();
        WorldWarIIAirplane ww2 = new WorldWarIIAirplane();
        WorldWarIIAirplane ww3 = new WorldWarIIAirplane();

        Metro m1 = new Metro();

//        System.out.println(a1.equals(a2)); // true
//
//        System.out.println(a1.equals(m1)); // false
//
//        System.out.println(ww2.equals(ww3)); // true

        Object[] test = new Object[2];

        test[0] = new Aircraft();
        test[1] = new WorldWarIIAirplane();

        findLeastAndMostExpensiveAircraft(test);



    }

    public static void findLeastAndMostExpensiveAircraft(Object[] objects){

        Aircraft[] acs = new Aircraft[objects.length];
        Aircraft mostExpensive;
        Aircraft leastExpensive;
        int aircraftCount = 0;

        for (Object o: objects
             ) {

            if (o.getClass() == Aircraft.class){
                System.out.println("Found the aircraft!");
                for (int i = 0; i< acs.length; i++){
                    if(acs[i] == null){
                        acs[i] = (Aircraft) o;
                        aircraftCount++;
                    }
                }
            }


        }
        // if only one aircraft then its both most expensive and least
        if (aircraftCount == 1){
            System.out.println("The information of the least and most expensive aircraft is:\n" + acs[0]);
        }

        // if no aircrafts
        else if (aircraftCount == 0) {
            System.out.println("There were no Aircrafts found in this list.");

        }

        // if more than one aircraft, sort
        else{
            mostExpensive = acs[0];
            leastExpensive = acs[0];
            for (Aircraft a: acs
            ) {
                if (a.getPrice() > mostExpensive.getPrice()){
                    mostExpensive = a;
                }
                if (a.getPrice() < leastExpensive.getPrice()){
                    leastExpensive = a;
                }
            }

            System.out.println("The most expensive aircraft is: \n" + mostExpensive + "\n\nThe least expensive aircraft is " + leastExpensive + "\n");

        }




    }
}
