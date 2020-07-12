package DAO;
import java.sql.SQLException;
import java.util.List;

public interface IUser<T> {
    void insert(T t) throws SQLException;
    T select(int id);
    List<T> selectAll();
    boolean delete(int id) throws SQLException;
    boolean update(T t) throws SQLException;
}
