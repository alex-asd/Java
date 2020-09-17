package Server.DataLayer;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * A simple table-specific adapter for Java-to-SQL operations.
 * This class has a constructor and attributes representing a row in the database table it represents.
 * The class has static methods for creating(Factory method), updating and deleting rows in the database table it
 * represents.
 *
 * @author Vito Ilchev
 */

public class Task implements Model {
    public final int taskID;
    public final Project project;
    public String TASK_TYPE;
    public final User createdBy;
    public final LocalDateTime createdAt;
    public final String taskText;

    public Task(int taskID, Project project, String TASK_TYPE, User createdBy, LocalDateTime createdAt, String taskText) {
        this.taskID = taskID;
        this.project = project;
        this.TASK_TYPE = TASK_TYPE;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.taskText = taskText;
    }

    /**
     * Factory method creates a row in the table and creates and return an object representing that value.
     * @param project - Tells the server which project the task should be added to
     * @param TASK_TYPE - The state of the task
     * @param createdBy - The author of the task
     * @param createdAt - The time that the task is created at
     * @param taskText - A string that contains the Task
     * @return
     * @throws SQLException
     */
    public synchronized static Task create(Project project, String TASK_TYPE, User createdBy, LocalDateTime createdAt, String taskText) throws SQLException{
        try {
            Timestamp timestamp = Timestamp.valueOf(createdAt);
            int taskID = Creator.create("tasks", "task_id",
                    asList("project_id","task_type","created_by", "created_at", "task_text"),
                    project.projectID, TASK_TYPE, createdBy.userID, timestamp, taskText);
            return new Task(taskID, project, TASK_TYPE, createdBy, createdAt, taskText);
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
    public static ArrayList<Task> getAll() throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase =  MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT * FROM \"TeamTool\".tasks ORDER BY created_at;";
        ArrayList<Object[]> objArrayList = myDatabase.query(select);
        ArrayList<Task> result = new ArrayList<>();

        // This is faster:
        objArrayList.parallelStream().forEachOrdered(objArray -> {
            int taskID = (int) objArray[0];
            Project project = null;
            try {
                project = Project.find((int) objArray[1]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String task_type = (String) objArray[2];
            User user = null;
            try {
                user = User.find((Integer) objArray[3]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Timestamp timestamp = (Timestamp) objArray[4];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            String task_text = (String) objArray[5];
            result.add(new Task(taskID, project, task_type, user, createdAt, task_text));
        });

        //This is slow:

        /*for (Object[] objArray : objArrayList) {
            int taskID = (int) objArray[0];
            Project project = Project.find((int) objArray[1]);
            String task_type = (String) objArray[2];
            User user = User.find((Integer) objArray[3]);
            Timestamp timestamp = (Timestamp) objArray[4];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            String task_text = (String) objArray[5];
            result.add(new Task(taskID, project, task_type, user, createdAt, task_text));
        } */

        return result;
    }

    /**
     * Returns an object corresponding to the row with the given unique ID.
     * @param taskID Is unique ID that identifies the task
     * @return
     * @throws SQLException
     */
    public static Task find(int taskID) throws SQLException {
        MyDatabase myDatabase = null;
        try {
            myDatabase = MyDBSingleton.getDBinstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String select = "SELECT * FROM \"TeamTool\".tasks WHERE task_id = ?;";
        ArrayList<Object[]> objArrayList = myDatabase.query(select, taskID);
        ArrayList<Task> result = new ArrayList<>();
        for (Object[] objArray : objArrayList) {
            int foundTaskID = (int) objArray[0];
            Project project = Project.find((int) objArray[1]);
            String task_type = (String) objArray[2];
            User user = User.find((Integer) objArray[3]);
            Timestamp timestamp = (Timestamp) objArray[4];
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            String task_text = (String) objArray[5];
            result.add(new Task(taskID, project, task_type, user, createdAt, task_text));
        }

        if (result.size() == 1) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     * Deletes the row with the given unique ID.
     * @param taskID
     * @throws SQLException
     */
    public static synchronized void delete(int taskID) throws SQLException {
        String delete = "DELETE FROM \"TeamTool\".tasks WHERE task_id = ?;";
        try {
            MyDBSingleton.getDBinstance().update(delete, taskID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the task_type attribute in the row with the given unique ID.
     * @param taskID is the unique ID that identifies the task
     * @throws SQLException
     */
    public static synchronized void setTaskToDoing(int taskID) throws SQLException {
        String update = "UPDATE \"TeamTool\".tasks SET task_type = \'DOIN\' WHERE task_id = ?;";
        try {
            MyDBSingleton.getDBinstance().update(update, taskID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the task_type attribute in the row with the given unique ID.
     * @param taskID is the unique ID that identifies the task
     * @throws SQLException
     */
    public static synchronized void setTaskToDone(int taskID) throws SQLException {
        String update = "UPDATE \"TeamTool\".tasks SET task_type = \'DONE\' WHERE task_id = ?;";
        try {
            MyDBSingleton.getDBinstance().update(update, taskID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


