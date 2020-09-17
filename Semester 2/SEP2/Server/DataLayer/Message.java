package Server.DataLayer;

import java.sql.Timestamp;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.util.Arrays.asList;


/**
 * A simple table-specific adapter for Java-to-SQL operations.
 * This class has a constructor and attributes representing a (potential) row in the database table in represents.
 * The class has static methods for creating(Factory method), updating rows in the database table it
 * represents.
 *
 * @author Vito Ilchev
 */
public class Message implements Model {
    public int messageID;
    public final User createdBy;
    public String messageText;
    public final LocalDateTime createdAt;
    public final Project project;

    public Message(int messageID, User createdBy, String messageText, LocalDateTime createdAt, Project project) {
        this.messageID = messageID;
        this.createdBy = createdBy;
        this.messageText = messageText;
        this.createdAt = createdAt;
        this.project = project;
    }

    /**
     * Factory method creates a row in the table and creates and return an object representing that value.
     * @param createdBy is the author of the message
     * @param messageText is the String containing the Message
     * @param createdAt is the time the message is created
     * @param project is the project, which should be searched for
     * @return
     * @throws SQLException
     */
    public static synchronized Message create(User createdBy, String messageText, LocalDateTime createdAt, Project project)
            throws SQLException {
        try {

            Timestamp timestamp = Timestamp.valueOf(createdAt);


            int messageID = Creator.create(
                    "messages","message_id",
                    asList("created_by","message_text","created_at","project_id"),
                    createdBy.userID, messageText, timestamp, project.projectID);

            return new Message(messageID, createdBy, messageText, createdAt, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a list of objects representing all the rows in the table.
     * @return
     * @throws SQLException
     */
    public static ArrayList<Message> getAll() throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT * " +
                "FROM \"TeamTool\".messages ORDER BY created_at;";
        ArrayList<Object[]> objArrayList = myDatabase.query(select);

        ArrayList<Message> result = new ArrayList<>();

        objArrayList.parallelStream().forEachOrdered(objArray -> {
            int messageID = (int) objArray[0];
            User createdBy = null;
            try {
                createdBy = User.find((Integer) objArray[1]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String messageText = (String) objArray[2];
            Timestamp timestamp = (Timestamp) objArray[3];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Project project = null;
            try {
                project = Project.find((int) objArray[4]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            result.add(new Message(messageID, createdBy, messageText, createdAt, project));
        });

        /* for (Object[] objArray : objArrayList) {
            int messageID = (int) objArray[0];
            User createdBy = User.find((Integer) objArray[1]);
            String messageText = (String) objArray[2];
            Timestamp timestamp = (Timestamp) objArray[3];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Project project = Project.find((int) objArray[4]);
            result.add(new Message(messageID, createdBy, messageText, createdAt, project));
        } */

        return result;
    }

}
