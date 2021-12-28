package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

/**
 * @author sithum
 */
public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws Exception;
}
