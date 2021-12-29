package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * @author sithum
 */
public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws Exception;

    List getLastId();

    ObservableList<String> getAll() throws Exception;
}
