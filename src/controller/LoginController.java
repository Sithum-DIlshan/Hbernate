package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author sithum
 */
public class LoginController {

    public void login(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}
