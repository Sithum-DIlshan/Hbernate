package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import tdm.StudentDetailsTM;

import java.util.List;

/**
 * @author sithum
 */
public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws Exception;

    List getLastId();

    ObservableList<String> getAllIds() throws Exception;

    StudentDTO search(String id) throws Exception;

    void update(StudentDTO studentDTO) throws Exception;

    ObservableList<StudentDetailsTM> getAll() throws Exception;
}
