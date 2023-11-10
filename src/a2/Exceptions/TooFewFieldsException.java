package a2.Exceptions;

public class TooFewFieldsException extends Throwable {
    public String msg;

    public TooFewFieldsException(String[] fields){
        msg = "Error: too few fields\nRecord: ";
        for (String field : fields) {
            msg += ","+ field;
        }
        msg += "\n";
    }


}


