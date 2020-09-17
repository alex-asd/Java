package Client.GUI.controllers;

import Client.GUI.GUIMain;
import Client.GUI.GeneralModel;
import Client.RMIClient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 *
 * @author Palle Sohn Christensen
 *
 */
public class LoginController {

    private GeneralModel generalModel;

    public void setGeneralModel(GeneralModel generalModel) {
        this.generalModel = generalModel;
    }

    private RMIClient rmiClient;

    public void setRMIclient(RMIClient rmIclient) {
        this.rmiClient = rmIclient;
    }

    private GUIMain guiMain;

    public void setGUImain (GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    private Stage prevStage;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    @FXML
    private Button loginBtn; // fx:id="loginBtn"

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField serverIPField;

    @FXML
    private TextField serverPortField;

    public void initialize() {

        assert loginBtn != null;

        assert usernameField != null;

        assert passwordField != null;

        assert serverIPField != null;

        assert serverPortField != null;

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()
                        && !serverIPField.getText().isEmpty() && !serverPortField.getText().isEmpty()) {
                    try {
                        rmiClient.lookup(serverIPField.getText(), Integer.valueOf(serverPortField.getText()));
                        rmiClient.login(usernameField.getText(), passwordField.getText());
                        if (rmiClient.getCurrentSessionID() != null) {
                            Stage stage = new Stage();
                            stage.setTitle("Team Collaboration Tool");

                            Pane myPane = null;
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Client/GUI/view/OverallGUI.fxml"));
                                OverAllGuiController overAllGuiController = new OverAllGuiController();
                                overAllGuiController.setRmiClient(rmiClient);
                                overAllGuiController.setGUImain(guiMain);
                                overAllGuiController.setGeneralModel(generalModel);
                                overAllGuiController.setStage(stage);
                                fxmlLoader.setController(overAllGuiController);
                                myPane = fxmlLoader.load();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            Scene scene = new Scene(myPane);

                            stage.setScene(scene);
                            scene.getRoot().requestFocus();

                            prevStage.close();

                            stage.show();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
