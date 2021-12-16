package lk.ijse.studentrreg.hibernate.dao;

import lk.ijse.studentrreg.hibernate.dao.custom.impl.ProgramsDaoImpl;
import lk.ijse.studentrreg.hibernate.dao.custom.impl.StudentDaoImpl;

/**
 * @author sithum
 */
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case PROGRAMS:
                return new ProgramsDaoImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
       STUDENT, PROGRAMS
    }

}
