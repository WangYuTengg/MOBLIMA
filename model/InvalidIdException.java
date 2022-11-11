package model;

public class InvalidIdException extends Exception  
{  
    public InvalidIdException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  