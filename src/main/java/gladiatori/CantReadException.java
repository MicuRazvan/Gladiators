package gladiatori;

public class CantReadException extends RuntimeException{
    public CantReadException(){
        super("Cant read");
    }
}