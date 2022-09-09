package platform.codingnomads.co.springtest.usingtestresttemplate;

public class NoSuchCoffeeException extends Exception{
    public NoSuchCoffeeException(String message){
        super(message);
    }

    public NoSuchCoffeeException(){}
}
