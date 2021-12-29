package dao.custom.impl;

import dao.FactoryConfiguration;
import dao.custom.StudentDao;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * @author sithum
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean add(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public List<Program> search(String s) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Student");
        List results = q.getResultList();
        tx.commit();
        session.close();
        return results;
    }

    @Override
    public List getLastId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select count(studentId) from Student");
        List results = q.getResultList();
        tx.commit();
        session.close();
        return results;
    }
}
