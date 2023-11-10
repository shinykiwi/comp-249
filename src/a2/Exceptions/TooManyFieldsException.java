package a2.Exceptions;

public class TooManyFieldsException extends Exception{
    public String msg;

    public TooManyFieldsException(String[] fields){
        msg = "Error: too many fields\nRecord: ";
        for (String field : fields) {
            msg += "," + field;
        }
        msg += "\n";

    }

}
