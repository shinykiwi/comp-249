// Assignment 3
// Written by Kira Fountain 40192824

package a3;

import java.util.Scanner;

public class CellPhone {

    long serialNum;
    String brand;
    int year;
    double price;
    static int counter = 0;

    public CellPhone(CellPhone cellPhone) {
        this.brand = cellPhone.getBrand();
        this.year = cellPhone.getYear();
        this.price = cellPhone.getPrice();
        serialNum = counter;
        counter++;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public long getSerialNum() {
        return serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public CellPhone(int year, double price, String brand){
        this.serialNum = counter;
        this.year = year;
        this.price = price;
        this.brand = brand;
        counter++;
    }

    public CellPhone(long serialNum, String brand, double price, int year){
        this.serialNum = serialNum;
        this.year = year;
        this.price = price;
        this.brand = brand;
    }

    public CellPhone(CellPhone cp, long serialNum){
        this.serialNum = serialNum;
        this.year = cp.getYear();
        this.price = cp.getPrice();
        this.brand = cp.getBrand();
    }

    public CellPhone clone(){
        Scanner s = new Scanner(System.in);
        System.out.println("\nPlease enter a serial number: ");
        return new CellPhone(this, s.nextLong());
    }

    public String toString(){
        return "["+serialNum + ": "+ brand + " " + price + "$ "+year+"]";
    }

    public boolean equals(CellPhone cp) {
        return this.year == cp.getYear() && this.price == cp.getPrice() && this.brand.equals(cp.getBrand());
    }


}
