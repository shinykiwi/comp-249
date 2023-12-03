package a3;

// ------------------------------------------------
// Assignment 3
// Question IV
// Written by: Kira Fountain 40192824
// -------------------------------------------------

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CellListUtilization {

    public static void main(String[] args) {
        CellList l1 = new CellList();
        CellList l2 = new CellList();

        try{

            Scanner reader = new Scanner(new FileInputStream("./src/a3/Cell_Info.txt"));
            Scanner input = new Scanner(System.in);
            while (reader.hasNextLine()){
                l1.addToStart(new CellPhone(reader.nextLong(), reader.next(), reader.nextDouble(), reader.nextInt()));
            }

            // showing contents of list just created from file
            l1.showContents();

        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file!");
        }









    }

}
