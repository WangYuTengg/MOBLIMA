package model;

/**
* Represents the User Class.
* @version  1.0
* @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
* @since    2022-10-30
*/
public class User implements java.io.Serializable{

    /**
     * The name of the user.
     */
    private String name;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The constructor of a user.
     * @param name      The name of the user.
     * @param email     The email of the user.
     * @param password  The password of the user.
     */
    public User(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the name of the user.
     * @return  The name of the user.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the email of the user.
     * @return  The email of the user.
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * Gets the password of the user.
     * @return  The password of the user.
     */
    public String getPassword()
    {
        return this.password;
    }
}
