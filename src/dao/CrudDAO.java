package dao;

import java.util.List;

/**
 * @author sithum
 */
public interface CrudDAO<T, ID> extends SuperDAO {
    boolean add(T t) throws Exception;

    boolean delete(ID id) throws Exception;

    boolean update(T t) throws Exception;

    T search(ID id) throws Exception;

    List<T> getAll() throws Exception;
}
