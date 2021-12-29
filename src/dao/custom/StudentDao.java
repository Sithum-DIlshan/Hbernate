package dao.custom;

import dao.CrudDAO;
import entity.Student;

import java.util.List;

/**
 * @author sithum
 */
public interface StudentDao extends CrudDAO<Student, String> {
    List getLastId();
}
