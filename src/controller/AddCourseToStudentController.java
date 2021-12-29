package controller;

import bo.BOFactory;
import bo.custom.ProgramsBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sithum
 */
public class AddCourseToStudentController implements Initializable {
    public JFXComboBox cmbSelectStudent;
    public JFXComboBox cmbSelectProgram;
    public JFXButton add;
    ProgramsBO program = (ProgramsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PROGRAMS);
    StudentBO studentBo = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectStudent();
        selectProgram();
        add_init();
    }

    private void add_init() {

    }

    private void selectProgram() {
        cmbSelectProgram.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                cmbSelectProgram.setItems(program.getAllPrograms());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void selectStudent() {
        cmbSelectStudent.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                cmbSelectStudent.setItems(studentBo.getAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
