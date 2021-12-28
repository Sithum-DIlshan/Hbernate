package bo.custom.impl;


import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDao;
import dto.StudentDTO;
import entity.Student;
import entity.embedded.Name;

/**
 * @author sithum
 */
public class StudentBOImpl implements StudentBO {
    StudentDao dao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return dao.add(new Student(
                dto.getStudentId(),
                new Name(dto.getfName(), dto.getmName(), dto.getlName()),
                dto.getAddress(),
                dto.getParentName(),
                dto.getContactNo(),
                dto.getDob(),
                dto.getAge(),
                dto.getGender(),
                dto.getEmail(),
                dto.getProvince(),
                dto.getCourse()
        ));
    }


}
