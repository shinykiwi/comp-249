package a2.Exceptions;

public class BadYearException extends Throwable{
    public String msg;
    public BadYearException(String s) {
        msg = s;

    }
}
