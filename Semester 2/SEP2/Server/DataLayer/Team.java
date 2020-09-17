package Server.DataLayer;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * A simple table-specific adapter for Java-to-SQL operations.
 * This class has a constructor and attributes representing a (potential) row in the database table in represents.
 * The class has static methods for creating(Factory method), updating and deleting rows in the database table it
 * represents.
 *
 * @author Sergiu Ivanov
 */
public class Team implements Model {
    final int teamID;
    final String name;

    Team(int teamID, String name) {
        this.teamID = teamID;
        this.name = name;
    }

    static ArrayList<Team> findWhere(String where) throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT team_id, name FROM \"TeamTool\".teams WHERE "+where+";";
        ArrayList<Object[]> objArrayList = myDatabase.query(select);

        ArrayList<Team> result = new ArrayList<>();
        for (Object[] objArray : objArrayList) {
            int teamID = (int) objArray[0];
            String name = (String) objArray[1];
            result.add(new Team(teamID, name));
        }

        return result;
    }

    /**
     * Finds a row with the given unique ID and returns an object representing the row.
     * @param teamID is the unique ID that identifies the team
     * @return
     * @throws SQLException
     */
    static Team find(int teamID) throws SQLException {
        return findWhere("team_id="+teamID).get(0);
    }

    static Team find(String name) throws SQLException {
        return findWhere("name="+name).get(0);
    }

}
