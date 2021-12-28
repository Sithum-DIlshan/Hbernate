package controller;

import bo.BOFactory;
import bo.SuperBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import dto.StudentDTO;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

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
    public AnchorPane anchor;
    public JFXButton btnEffect;
    public ImageView image;
    public Pane home;
    public Pane addStudentPane;
    public Pane addProgramPane;
    public Pane studentDetails;
    public AnchorPane mainAnchor;
    public StackPane parentStack;
    public TableView tblStudentDetails;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colAge;
    public TableColumn colGender;
    public TableColumn colEmail;
    public TableColumn colCourse;
    public JFXTextField txtFname;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtParentname;
    public JFXTextField txtMname;
    public JFXTextField txtLname;
    public JFXDatePicker dob;
    public JFXRadioButton male;
    public JFXRadioButton female;
    public JFXTextField txtEmail;
    public JFXTextField province;
    public JFXTextField age;
    public JFXButton saveStudentBtn;
    public JFXComboBox cmbPrograms;
    public Pane ttlStudents;
    public Label lblStudentCount;
    public Pane ttlPrograms;
    public Label lblttlProgramsCount;
    public JFXTextField txtProgramName;
    public JFXTextField txtProgramId;
    public JFXTextField fee;
    public JFXTextField txtDuration;
    public JFXButton saveProgramBtn;
    
    StudentBO studentBo = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void loadHome() {
        home.setVisible(true);
        addStudentPane.setVisible(false);
        addProgramPane.setVisible(false);
        studentDetails.setVisible(false);
    }

    void loadAddStudent() {
        home.setVisible(false);
        addStudentPane.setVisible(true);
        addProgramPane.setVisible(false);
        studentDetails.setVisible(false);
        /* System.out.println("loaded");*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveStudent();
        try {
            VBox box = FXMLLoader.load(getClass().getClassLoader().getResource("view/nodes/SideMenu.fxml"));
            drawer.setSidePane(box);

            for (Node node : box.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        switch (node.getAccessibleText()) {
                            case "add_student":
                                home.setVisible(false);
                                addProgramPane.setVisible(false);
                                addStudentPane.setVisible(true);
                                studentDetails.setVisible(false);
                                break;
                            case "add_program":
                                /*home.setVisible(true);
                                addStudentPane.setVisible(false);*/
                                home.setVisible(false);
                                addStudentPane.setVisible(false);
                                addProgramPane.setVisible(true);
                                studentDetails.setVisible(false);
                                break;
                            case "home":
                                home.setVisible(true);
                                addStudentPane.setVisible(false);
                                studentDetails.setVisible(false);
                                addProgramPane.setVisible(false);
                                break;
                            case "student_details":
                                home.setVisible(false);
                                addStudentPane.setVisible(false);
                                studentDetails.setVisible(true);
                                addProgramPane.setVisible(false);
                                break;
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask2.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
            TranslateTransition closeNav = new TranslateTransition(new Duration(350), anchor);
            closeNav.setToX(0);
            TranslateTransition openNav = new TranslateTransition(new Duration(350), anchor);
            openNav.setToX(234);
            if (drawer.isOpened()) {
                closeNav.play();
                drawer.close();
                /*anchor.setTranslateX(0);*/

            } else {
                drawer.open();
                openNav.play();
            }
        });

    }

    private void saveStudent() {
        saveStudentBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            StudentDTO dto = new StudentDTO("S-001", txtFname.getText(), txtMname.getText(), txtLname.getText(), txtAddress.getText(), txtParentname.getText(), txtContactNo.getText(), dob.getValue(), Integer.parseInt(age.getText()), "male", txtEmail.getText(), province.getText(), String.valueOf(cmbPrograms.getSelectionModel().selectedItemProperty().getValue()));
            try {
                studentBo.saveStudent(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    public void playMouseEnter(MouseEvent mouseEvent) {
        Pane pane = (Pane) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), pane);
        scaleT.setToX(1.07);
        scaleT.setToY(1.07);
        scaleT.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.CORNFLOWERBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        pane.setEffect(glow);
    }

    public void playMouseExit(MouseEvent mouseEvent) {
        Pane pane = (Pane) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), pane);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

        pane.setEffect(null);
    }
}
