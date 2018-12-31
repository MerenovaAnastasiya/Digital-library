package repositories;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface CrudRepository<T> {
    Optional<T> findOne(Long id);
    void save(T model) throws SQLException;
    void delete(Long id);
    List<T> findAll();
}
