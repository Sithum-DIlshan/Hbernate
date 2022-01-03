package controller;

import bo.BOFactory;
import bo.custom.ProgramsBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import view.util.Dialog;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    public Label allReadyOnAction;

    StudentBO studentBo = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    ProgramsBO program = (ProgramsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAMS);

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
        studentUpdate();
        try {
            studentDetailsTable_init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            welcomePane_init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveStudent();
        saveProgram();
        loadComboBoxPrograms();
        ToggleGroup gender = new ToggleGroup();
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
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
                                try {
                                    welcomePane_init();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "student_details":
                                home.setVisible(false);
                                addStudentPane.setVisible(false);
                                studentDetails.setVisible(true);
                                addProgramPane.setVisible(false);
                                try {
                                    studentDetailsTable_init();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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

    private void welcomePane_init() throws Exception {
        lblStudentCount.setText(String.valueOf(studentBo.getAllIds().size()));
        lblttlProgramsCount.setText(String.valueOf(program.getAllPrograms().size()));
    }

    private void studentDetailsTable_init() throws Exception {
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblStudentDetails.setItems(studentBo.getAll());
    }

    private void saveProgram() {
        saveProgramBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                if (txtProgramName.getText().isEmpty() | txtProgramId.getText().isEmpty() | fee.getText().isEmpty() | txtDuration.getText().isEmpty()) {
                    Dialog.showDialog("fill all fields", parentStack, "ok");
                } else {
                    program.save(new ProgramDTO(txtProgramId.getText(), txtProgramName.getText(), Integer.parseInt(txtDuration.getText()), Double.parseDouble(fee.getText())));
                    txtProgramName.clear();
                    txtProgramId.clear();
                    fee.clear();
                    txtDuration.clear();
                    Dialog.showDialog("Program Saved", parentStack, "done");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void studentUpdate() {
        allReadyOnAction.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/nodes/AddCourseToStudent.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadComboBoxPrograms() {
        /*try {
            cmbPrograms.setValue(program.getAllPrograms());
            *//*System.out.println(program.getAllPrograms());*//*
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        cmbPrograms.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            try {
                cmbPrograms.setItems(program.getAllPrograms());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void saveStudent() {
        saveStudentBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                if (txtFname.getText().isEmpty() | txtMname.getText().isEmpty() | txtLname.getText().isEmpty() | txtParentname.getText().isEmpty() | txtContactNo.getText().isEmpty() | txtAddress.getText().isEmpty() | dob.getEditor().getText().isEmpty() | age.getText().isEmpty() | txtEmail.getText().isEmpty() | province.getText().isEmpty() | cmbPrograms.getSelectionModel().isEmpty()) {
                    Dialog.showDialog("Please fill all fields", parentStack, "ok");
                } else if (!(male.isSelected() | female.isSelected())) {
                    Dialog.showDialog("Please select gender are you gay?", parentStack, "ok");
                } else {
                    StudentDTO dto = new StudentDTO(getLastStudentId(), txtFname.getText(), txtMname.getText(), txtLname.getText(), txtAddress.getText(), txtParentname.getText(), txtContactNo.getText(), dob.getValue(), Integer.parseInt(age.getText()), "male", txtEmail.getText(), province.getText(), String.valueOf(cmbPrograms.getSelectionModel().selectedItemProperty().getValue()));
                    studentBo.saveStudent(dto);
                    txtFname.clear();
                    txtMname.clear();
                    txtLname.clear();
                    txtAddress.clear();
                    txtContactNo.clear();
                    txtParentname.clear();
                    dob.getEditor().clear();
                    age.clear();
                    txtEmail.clear();
                    province.clear();
                    female.setSelected(false);
                    male.setSelected(false);
                    Dialog.showDialog("Student Saved", parentStack, "done");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    private String getLastStudentId() {
        List lastId = studentBo.getLastId();
        long tempId = (long) lastId.get(0);
        if (tempId > 0) {
            tempId = tempId + 1;
            if (tempId < 9) {
                return "S-00" + tempId;
            } else if (tempId < 99) {
                return "S-0" + tempId;
            } else {
                return "S-" + tempId;
            }
        }
        return "S-001";
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
