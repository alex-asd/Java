package Server.DataLayer;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * A simple table-specific adapter for Java-to-SQL operations.
 * @author Vito Ilchev
 */
public class Project implements Model {
    public final int projectID;
    public final Team team;
    public final String name;
    public LocalDateTime createdAt;

    public Project(int projectID, Team team, String name, LocalDateTime createdAt) {
        this.projectID = projectID;
        this.team = team;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Project(int projectID, Team team, String name) {
        this.projectID = projectID;
        this.team = team;
        this.name = name;
    }

    private synchronized static ArrayList<Project> findWhere(String where) throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT * FROM \"TeamTool\".projects WHERE "+where+";";
        ArrayList<Object[]> objArrayList = myDatabase.query(select);

        ArrayList<Project> result = new ArrayList<>();
        for (Object[] objArray : objArrayList) {
            int projectID = (int) objArray[0];
            int teamID = (int) objArray[1];
            Team team = Team.find(teamID);
            String name = (String) objArray[2];
            Timestamp timestamp = (Timestamp) objArray[3];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            result.add(new Project(projectID, team, name, createdAt));
        }

        return result;
    }

    /**
     * Finds a row with the given unique ID and returns an object representing the row.
     * @param projectID is a unique ID that identifies the project
     * @return
     * @throws SQLException
     */
    public synchronized static Project find(int projectID) throws SQLException {
        return findWhere("project_id="+projectID).get(0);
    }


}
