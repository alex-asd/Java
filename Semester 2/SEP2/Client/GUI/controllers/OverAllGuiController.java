package Client.GUI.controllers;

import Client.GUI.GUIMain;
import Client.GUI.GeneralModel;
import Client.RMIClient;
import Common.MessageHolder;
import Common.TaskHolder;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class OverAllGuiController {

    private GeneralModel generalModel;

    public void setGeneralModel(GeneralModel generalModel) {
        this.generalModel = generalModel;
    }

    private RMIClient rmiClient;

    public void setRmiClient(RMIClient rmiClient) {
        this.rmiClient = rmiClient;
    }

    private GUIMain guiMain;

    public void setGUImain (GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Button addBtn;
    @FXML
    private TextField taskField; // fx:id="taskField"
    @FXML
    private ListView<TaskHolder> toDoList; // fx:id="toDoList"
    @FXML
    private Button deleteBtn; // fx:id="deleteBtn"
    @FXML
    private ListView<TaskHolder> doingList;
    @FXML
    private ListView<TaskHolder> doneList;
    @FXML
    private Button moveDoingBtn; // fx:id="moveDoingBtn"
    @FXML
    private Button moveDoneBtn; // fx:id="moveDoneBtn"
    @FXML
    private MenuItem createProjectItem; // fx:id="createProjectItem"
    @FXML
    private MenuItem deleteProjectItem; // fx:id="deleteProjectItem"
    @FXML
    private MenuItem createUserItem; // fx:id="createUserItem"
    @FXML
    private MenuItem deleteUserItem; // fx:id="deleteUserItem"
    @FXML
    private ListView<String> chatArea; // fx:id="chatArea"
    @FXML
    private Button sendBtn; // fx:id="sendBtn"
    @FXML
    private TextField sendMsgField;

    public void initialize() {
        assert taskField != null;
        assert addBtn != null;
        assert deleteBtn != null;
        assert doingList != null;
        assert doneList != null;
        assert moveDoingBtn != null;
        assert moveDoneBtn != null;
        assert chatArea != null;
        assert sendBtn != null;
        assert sendMsgField != null;

        generalModel.setToDoList(toDoList);
        generalModel.setDoingList(doingList);
        generalModel.setDoneList(doneList);

        chatArea.setItems(generalModel.getMessages());



        addBtn.setOnAction(event -> {
            if (taskField.getText() != null && !taskField.getText().isEmpty()) {
                rmiClient.addTask(new TaskHolder("TODO", taskField.getText()));
                taskField.clear();
            }
        });

        taskField.setOnAction(event -> {
            if (taskField.getText() != null && !taskField.getText().isEmpty()) {
                rmiClient.addTask(new TaskHolder("TODO", taskField.getText()));
                taskField.clear();
            }
        });

        sendBtn.setOnAction(event -> {
            if (sendMsgField.getText() != null
                    && !sendMsgField.getText().isEmpty()) {
                MessageHolder messageHolder = new MessageHolder(sendMsgField.getText());
                try {
                    rmiClient.sendMessage(messageHolder);
                    sendMsgField.clear();
                    chatArea.scrollTo(chatArea.getItems().size()-1);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });

        sendMsgField.setOnAction(event -> {
            if (sendMsgField.getText() != null
                    && !sendMsgField.getText().isEmpty()) {
                MessageHolder messageHolder = new MessageHolder(sendMsgField.getText());
                try {
                    rmiClient.sendMessage(messageHolder);
                    sendMsgField.clear();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });



        moveDoingBtn.setOnAction(event -> {
                    ObservableList<TaskHolder> selectedTodoTasks = toDoList.getSelectionModel().getSelectedItems();
                    for (TaskHolder tH : selectedTodoTasks) {
                        tH.TASK_TYPE = "DOIN";
                        rmiClient.setTask(tH);
                    }
                }
        );
        moveDoneBtn.setOnAction(event -> {
            ObservableList<TaskHolder> selectedDoingTasks = doingList.getSelectionModel().getSelectedItems();
            for (TaskHolder tH : selectedDoingTasks) {
                tH.TASK_TYPE = "DONE";
                rmiClient.setTask(tH);
            }
        });

        deleteBtn.setOnAction(event -> {
            ObservableList<TaskHolder> selectedTodoTasks = toDoList.getSelectionModel().getSelectedItems();
            for (TaskHolder tH : selectedTodoTasks) {
                rmiClient.deleteTask(tH);
            }
            ObservableList<TaskHolder> selectedDoingTasks = doingList.getSelectionModel().getSelectedItems();
            for (TaskHolder tH : selectedDoingTasks) {
                rmiClient.deleteTask(tH);
            }
            ObservableList<TaskHolder> selectedDoneTasks = doneList.getSelectionModel().getSelectedItems();
            for (TaskHolder tH : selectedDoneTasks) {
                rmiClient.deleteTask(tH);
            }
        });

        rmiClient.loadExistingItems();

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
