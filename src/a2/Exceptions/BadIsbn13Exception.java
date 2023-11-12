package a2.Exceptions;

public class BadIsbn13Exception extends Throwable{

    public String msg;
    public BadIsbn13Exception(String s){
        msg = s;
    }
}
