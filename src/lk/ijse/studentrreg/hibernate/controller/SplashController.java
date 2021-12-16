package lk.ijse.studentrreg.hibernate.controller;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sithum
 */
public class SplashController implements Initializable {

    public JFXProgressBar bar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fade = new FadeTransition(Duration.seconds(3), bar);
        fade.play();
        fade.setOnFinished(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent parent = loader.load(getClass().getClassLoader().getResourceAsStream("lk/ijse/studentrreg/hibernate/view/Login.fxml"));
                Scene scene = new Scene(parent);
                Stage stage1 = new Stage();
                stage1.initStyle(StageStyle.UNDECORATED);
                stage1.setScene(scene);
                stage1.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) bar.getScene().getWindow();
            stage.close();
        });
    }
}
