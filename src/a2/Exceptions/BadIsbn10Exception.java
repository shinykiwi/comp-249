package a2.Exceptions;

public class BadIsbn10Exception extends Throwable{

    public String msg;

    public BadIsbn10Exception(String s){
        msg = s;
    }


}
