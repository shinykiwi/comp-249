package a2.Exceptions;

public class UnknownGenreException extends Throwable{
    public String msg;
    public UnknownGenreException(String[] fields){
        msg = "Error: invalid genre\nRecord: ";
        for (String field : fields) {
            msg += "," +field;
        }
        msg += "\n";

    }

}
