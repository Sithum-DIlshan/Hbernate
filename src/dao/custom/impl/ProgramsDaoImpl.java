package dao.custom.impl;

import dao.FactoryConfiguration;
import dao.custom.ProgramsDao;
import entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * @author sithum
 */
public class ProgramsDaoImpl implements ProgramsDao {

    @Override
    public boolean add(Program program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(program);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Program program) {
        return false;
    }

    @Override
    public Program search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
       /* Query query = session.createQuery("from Program P where P.pId= :program_id");
        query.setParameter("program_id", s);
        List results = query.getResultList();*/
        Program program = session.get(Program.class, s);
        tx.commit();
        session.close();
        return program;
    }

    @Override
    public List<Program> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Program");
        List results = q.getResultList();
        tx.commit();
        session.close();
        return results;
    }
}
