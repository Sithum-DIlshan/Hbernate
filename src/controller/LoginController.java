package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.util.Dialog;

import java.io.IOException;

/**
 * @author sithum
 */
public class LoginController {

    public StackPane stack;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;


    public void login(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().isEmpty() | txtPassword.getText().isEmpty()) {
            Dialog.showDialog("fill all fields", stack, "ok");
        } else if (txtUserName.getText().equals("Sithum") && txtPassword.getText().equals("sithum123")) {
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } else {
            Dialog.showDialog("Invalid credentials try again", stack, "ok");
        }

    }
}
