package Client.GUI;

import Client.GUI.controllers.LoginController;
import Client.RMIClient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIMain extends Application {

    private Stage mainStage;

    public Stage getMainStage() {
        return this.mainStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/Client/GUI/view/LoginScreen.fxml"));
        Pane myPane = (Pane) myLoader.load();
        LoginController controller = (LoginController) myLoader.getController();
        GeneralModel generalModel = new GeneralModel();
        RMIClient rmiClient = new RMIClient(generalModel);
        controller.setGeneralModel(generalModel);
        controller.setRMIclient(rmiClient);

        controller.setPrevStage(primaryStage);

        controller.setGUImain(this);

        Scene myScene = new Scene(myPane);

        mainStage = primaryStage;

        primaryStage.setTitle("Team Collaboration Tool");

        primaryStage.setScene(myScene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            System.out.println("GUIMain closed");
        });
    }

    public static void main(String[] args) {

        for (String arg : args) {
            System.out.println(arg);
        }

        launch(args);
    }
}
