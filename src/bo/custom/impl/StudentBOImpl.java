package bo.custom.impl;


import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.ProgramsDao;
import dao.custom.StudentDao;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import entity.embedded.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tdm.StudentDetailsTM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sithum
 */
public class StudentBOImpl implements StudentBO {
    StudentDao sDao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ProgramsDao pDao = (ProgramsDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAMS);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        Program search = pDao.search(dto.getCourse());
        List<Program> programs = new ArrayList<>();
        programs.add(search);
        return sDao.add(new Student(dto.getStudentId(), new Name(dto.getfName(), dto.getmName(), dto.getlName()), dto.getAddress(), dto.getParentName(), dto.getContactNo(), dto.getDob(), dto.getAge(), dto.getGender(), dto.getEmail(), dto.getProvince(), programs));

    }

    @Override
    public List getLastId() {
        return sDao.getLastId();
    }

    @Override
    public ObservableList<String> getAllIds() throws Exception {
        List<Student> all = sDao.getAll();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for (Student s : all) {
            obs.add(s.getStudentId());
        }
        return obs;
    }

    @Override
    public StudentDTO search(String id) throws Exception {
        /*List<Student> search = */
        Student student = sDao.search(id);
        Name name = student.getName();
        List<Program> programList = student.getProgramList();
        List<ProgramDTO> list = new ArrayList<>();
        for (Program program : programList) {
            list.add(new ProgramDTO(program.getpId(), program.getProgram(), program.getDuration(), program.getFee()));
        }
        return new StudentDTO(student.getStudentId(), name.getFirstName(), name.getMiddleName(), name.getLastName(), student.getAddress(), student.getParentName(), student.getContactNo(), student.getDob(), student.getAge(), student.getGender(), student.getEmail(), student.getProvince(), list);

    }

    @Override
    public void update(StudentDTO studentDTO) throws Exception {
        List<ProgramDTO> programList = studentDTO.getProgramList();
        List<Program> list = new ArrayList<>();
        for (ProgramDTO program : programList) {
            list.add(new Program(program.getpId(), program.getProgram(), program.getDuration(), program.getFee()));
        }
        sDao.update(new Student(studentDTO.getStudentId(), new Name(studentDTO.getfName(), studentDTO.getmName(), studentDTO.getlName()), studentDTO.getAddress(), studentDTO.getParentName(), studentDTO.getContactNo(), studentDTO.getDob(), studentDTO.getAge(), studentDTO.getGender(), studentDTO.getEmail(), studentDTO.getProvince(), list));
    }

    @Override
    public ObservableList<StudentDetailsTM> getAll() throws Exception {
        ObservableList<StudentDetailsTM> obs = FXCollections.observableArrayList();
        List<Student> all = sDao.getAll();
        for (Student s : all) {
            Name name = s.getName();
            for (Program p : s.getProgramList()) {
                obs.add(new StudentDetailsTM(
                        name.getFirstName()+" "+name.getMiddleName(),
                        s.getContactNo(),
                        s.getAge(),
                        s.getGender(),
                        s.getEmail(),
                        p.getProgram()
                ));
            }
        }
        return obs;
    }


}
