package Client.GUI;

import Client.RMIClient;
import Common.TaskHolder;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.rmi.RemoteException;

/**
 * @author Apinayan Mohanthas
 *
 */
public class GeneralModel {
    private ObservableList<String> messages;
    private ListView<TaskHolder> toDoList;
    private ListView<TaskHolder> doingList;
    private ListView<TaskHolder> doneList;

    private RMIClient rmiClient;

    public GeneralModel() {
        messages = FXCollections.observableArrayList();
        try {
            rmiClient = new RMIClient(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> getMessages() {
        return messages;
    }

    public void setMessages(ObservableList<String> messages) {
        this.messages = messages;
    }

    public ListView<TaskHolder> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ListView<TaskHolder> toDoList) {
        this.toDoList = toDoList;
    }

    public ListView<TaskHolder> getDoingList() {
        return doingList;
    }

    public void setDoingList(ListView<TaskHolder> doingList) {
        this.doingList = doingList;
    }

    public ListView<TaskHolder> getDoneList() {
        return doneList;
    }

    public void setDoneList(ListView<TaskHolder> doneList) {
        this.doneList = doneList;
    }

}
