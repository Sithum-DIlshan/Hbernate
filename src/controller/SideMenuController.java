package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sithum
 */
public class SideMenuController implements Initializable {
    public JFXButton btnRegisterStudent;
    public JFXButton btnAddProgram;
    public JFXButton btnHome;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void regStudent(ActionEvent actionEvent) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Main.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        MainController controller = loader.getController();
        controller.loadAddStudent();
        stage.show();*/
    }
}
