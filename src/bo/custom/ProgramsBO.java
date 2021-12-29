package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import javafx.collections.ObservableList;

/**
 * @author sithum
 */
public interface ProgramsBO extends SuperBO {
    ObservableList<String> getAllPrograms() throws Exception;

    boolean save(ProgramDTO dto) throws Exception;

    void search(String id) throws Exception;
}
