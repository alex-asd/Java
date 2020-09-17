package Server.DataLayer;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;


/**
 * A simple table-specific adapter for Java-to-SQL operations.
 * This class has a constructor and attributes representing a (potential) row in the database table in represents.
 * The class has static methods for creating(Factory method), updating and deleting rows in the database table it
 * represents.
 *
 * @author Sergiu Ivanov
 */

public class User implements Model {
    final int userID;
    public final String username;
    String password;
    public String currentSessionID;
    public Instant currentSessionExpires;


    User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }



    static ArrayList<User> findWhere(String where) throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT user_id, username FROM \"TeamTool\".users WHERE "+where+";";
        ArrayList<Object[]> objArrayList = myDatabase.query(select);

        ArrayList<User> result = new ArrayList<>();
        for (Object[] objArray : objArrayList) {
            int userID = (int) objArray[0];
            String username = (String) objArray[1];
            result.add(new User(userID, username));
        }

        return result;
    }

    /**
     * Finds a row with the given unique ID and returns an object representing the row.
     * @param userID is the unique ID that identifies the user
     * @return
     * @throws SQLException
     */
    static User find(int userID) throws SQLException {
        return findWhere("user_id="+userID).get(0);
    }

    /**
     * Finds a row with the given attribute value and returns an object representing the row.
     * @param username is the String that should be searched for
     * @return
     * @throws SQLException
     */
    public static User find(String username) throws SQLException {
        return findWhere("username=\'"+username+"\'").get(0);
    }

    /**
     * Finds a row with the given corresponding attribute values and returns an object representing the row.
     * @param username is the String that should be searched checked for
     * @param password is the String that should be searched and checked for
     * @return
     * @throws SQLException
     */
    public static User validUser(String username, String password) throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT user_id, username, password FROM \"TeamTool\".users WHERE username=? AND password=?;";
        ArrayList<Object[]> objArrayList = myDatabase.query(select, username, password);
        for (Object[] objArray : objArrayList) {
            boolean usr = username.equals((String)objArray[1]);
            boolean pass = password.equals((String)objArray[2]);
            if (usr && pass) {
                return new User((int)objArray[0], (String)objArray[1]);
            }
            return null;
        }
        return null;
    }

}
