package controller;
import java.io.*;

public class Serialization {
    public static void write(Database db){
        try
        {
            FileOutputStream fileOut = new FileOutputStream("db.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(db);
            out.flush();
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in db.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    public static Database read(){
        Database db = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("db.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            db = (Database) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return db;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Database class not found");
            c.printStackTrace();
            return db;
        }
        return db;
    }
}