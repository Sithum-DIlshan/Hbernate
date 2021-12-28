package bo;

import bo.custom.ProgramsBO;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.impl.ProgramsDaoImpl;
import dao.custom.impl.StudentDaoImpl;

/**
 * @author sithum
 */
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
            return boFactory;
        }
        return boFactory;
    }

    //factory method
    public SuperBO getBO(BOFactory.BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case PROGRAMS:
                return new ProgramBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, PROGRAMS
    }
}
