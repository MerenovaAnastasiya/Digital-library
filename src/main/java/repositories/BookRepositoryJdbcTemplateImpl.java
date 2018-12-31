package repositories;

import models.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookRepositoryJdbcTemplateImpl implements BookRepository {
    private JdbcTemplate jdbcTemplate;

    public BookRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_FIND_ONE_BY_ID = "SELECT * FROM book WHERE id = ?;";

    //language=SQL
    private static final String SQL_FIND_ALL_BOOKS = "SELECT * FROM book";

    private RowMapper<Book> bookRowMapper = (resultSet, i) -> Book.builder()
            .id(resultSet.getLong("id"))
            .bookName(resultSet.getString("book_name"))
            .author(resultSet.getString("author"))
            .path(resultSet.getString("path"))
            .description(resultSet.getString("description"))
            .build();

    @Override
    public Optional<Book> findOne(Long id) {
        try {
            Optional<Book> book = Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_ID, bookRowMapper, id));
            return book;
        }
        catch (EmptyResultDataAccessException exception) {
            System.out.println("книга");
        }
        return Optional.empty();
    }

    @Override
    public void save(Book model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL_BOOKS, bookRowMapper);
    }
}
