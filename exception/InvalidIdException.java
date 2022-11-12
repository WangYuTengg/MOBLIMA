package exception;

/**
 * An Invalid ID Exception class inherited from Exception.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
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