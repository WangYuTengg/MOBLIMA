package exception;

/**
 * An exception class inherited from Exception.
 */
public class InvalidIdException extends Exception  
{  
    /**
     * Throws a specific exception error message determined by str.
     * @param str   The error message.
     */
    public InvalidIdException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  