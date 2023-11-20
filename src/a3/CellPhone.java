// Assignment 3
// Written by Kira Fountain 40192824

package a3;

public class CellPhone {

    long serialNum;
    String brand;
    int year;
    double price;
    static int counter = 0;

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

    public CellPhone(long serialNum, int year, double price, String brand){
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

    // TODO: fill in this part
    public Object clone(){

        return null;
    }

    public String toString(){
        return "This is a CellPhone, brand is " + brand + ", year is "+ year+", price is "+ price+ ", and serial number is "+ serialNum + ".";
    }

    public boolean equals(CellPhone cp) {
        return this.year == cp.getYear() && this.price == cp.getPrice() && this.brand.equals(cp.getBrand());
    }


}
