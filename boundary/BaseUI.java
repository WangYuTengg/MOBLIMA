package boundary;

import data.Database;

/**
 * The Base Interface.
 * @version  1.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public interface BaseUI {

    /**
     * The base interface for the UI.
     * @param db The database.
     */
    public void main(Database db);
    
    /**
     * Base display function for other UI to implement.
     */
    private void display()
    {

    }
}
