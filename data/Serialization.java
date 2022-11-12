package data;
import java.io.*;

/**
 * Serialization class for interacting with an external file for storage and access.
 * @version  1.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Serialization {

    /**
     * Serialization of the current database to be saved.
     * @param db    The database.
     */
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

    /**
     * Serialization of a file to read it into the program.
     * @return The database.
     */
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
