package a2.Exceptions;


public class BadPriceException extends Throwable {

    public String msg;

    public BadPriceException(String s){
        msg = s;
    }
}
