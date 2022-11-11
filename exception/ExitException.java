package exception;

public class ExitException extends Exception
{
	 public ExitException (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
}
