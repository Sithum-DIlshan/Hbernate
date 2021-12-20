package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sithum
 */
public class MainController implements Initializable {

    public BorderPane borderpane;
    public VBox vbox;
    public JFXHamburger hamburger;
    public JFXDrawer drawer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            VBox box = FXMLLoader.load(getClass().getClassLoader().getResource("view/nodes/SideMenu.fxml"));
            drawer.setSidePane(box);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HamburgerBackArrowBasicTransition burrgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
        burrgerTask2.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            burrgerTask2.setRate(burrgerTask2.getRate() * -1);
            burrgerTask2.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else drawer.open();
        });

        
    }

}
