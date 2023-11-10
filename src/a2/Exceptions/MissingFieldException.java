package a2.Exceptions;

public class MissingFieldException extends Throwable {
    public String msg;

    public MissingFieldException(String missingField, String[] fields){
        msg = "Error: missing " + missingField + "\nRecord: ";
        for (String field : fields) {
            msg += "," + field;
        }
        msg += "\n";

    }
}
