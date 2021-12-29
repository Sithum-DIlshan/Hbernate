package bo.custom.impl;


import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.ProgramsDao;
import dao.custom.StudentDao;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import entity.embedded.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * @author sithum
 */
public class StudentBOImpl implements StudentBO {
    StudentDao sDao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ProgramsDao pDao = (ProgramsDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAMS);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        List<Program> search = pDao.search(dto.getCourse());
        return sDao.add(new Student(dto.getStudentId(), new Name(dto.getfName(), dto.getmName(), dto.getlName()), dto.getAddress(), dto.getParentName(), dto.getContactNo(), dto.getDob(), dto.getAge(), dto.getGender(), dto.getEmail(), dto.getProvince(), search));

    }

    @Override
    public List getLastId() {
        return sDao.getLastId();
    }

    @Override
    public ObservableList<String> getAll() throws Exception {
        List<Student> all = sDao.getAll();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for (Student s : all) {
            obs.add(s.getStudentId());
        }
        return obs;
    }


}
