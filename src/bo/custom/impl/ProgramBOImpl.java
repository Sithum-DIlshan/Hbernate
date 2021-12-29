package bo.custom.impl;

import bo.custom.ProgramsBO;
import dao.DAOFactory;
import dao.custom.ProgramsDao;
import dto.ProgramDTO;
import entity.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * @author sithum
 */
public class ProgramBOImpl implements ProgramsBO {
    ProgramsDao dao = (ProgramsDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAMS);

    @Override
    public ObservableList<String> getAllPrograms() throws Exception {
        List<Program> all = dao.getAll();
        ObservableList<String> obs = FXCollections.observableArrayList();
        for (Program p : all) {
            obs.add(p.getpId());
        }
        return obs;
    }

    @Override
    public boolean save(ProgramDTO dto) throws Exception {
        return dao.add(new Program(dto.getpId(), dto.getProgram(), dto.getDuration(), dto.getFee()));
    }

    @Override
    public void search(String id) throws Exception {
        dao.search(id);
    }
}
