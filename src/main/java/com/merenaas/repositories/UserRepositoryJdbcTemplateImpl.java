package com.merenaas.repositories;

import com.merenaas.models.Basket;
import com.merenaas.models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component("userRepository")
public class UserRepositoryJdbcTemplateImpl implements UserRepository {


    private JdbcTemplate jdbcTemplate;
    private  RowMapper<User> userRowMapper = (resultSet, rowNum) -> {
        User user = User.builder()
                .id(resultSet.getLong("id"))
                .login(resultSet.getString("login"))
                .phoneNumber(resultSet.getString("phone_number"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .uuid(resultSet.getString("uuid"))
                .build();
        Basket basket = Basket.builder()
                .id(resultSet.getLong("basket_id"))
                .user(user)
                .build();
        user.setBasket(basket);
        return user;
    };

    public UserRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_INSERT =
            "INSERT INTO \"public\".library_user (\"id\", \"login\",  \"email\",\"password\", \"uuid\") VALUES (DEFAULT, ?, ?, ?,?)";
    //language=SQL
    private static final String SQL_FIND_ALL =
            "SELECT * FROM library_user";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_ID =
            "SELECT * FROM library_user WHERE id = ?;";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL =
            "SELECT * FROM library_user WHERE email = ?;";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_LOGIN =
            "SELECT * FROM library_user WHERE login = ?;";

    //language=SQL
    private static final String SQL_DELETE = "DELETE  FROM library_user WHERE id = ?;";

    //language=SQL
    private static final String SQL_INSERT_BASKET_ID_COLUMN = "UPDATE library_user SET basket_id = ? WHERE id = ?;";


    @Override
    public Optional<User> findOneByEmail(String email) {
        try {
            Optional<User> user = Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL, userRowMapper, email));
            return user;
        }
        catch (EmptyResultDataAccessException exception) {
            System.out.println("Юзер по email не найден");
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findOneByLogin(String login) {
        try {
            Optional<User> user = Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_LOGIN, userRowMapper, login));
            return user;
        }
        catch (EmptyResultDataAccessException exception) {
            System.out.println("Юзер по login не найден");
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findOne(Long id) {
        try {
            Optional<User> user = Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_ID, userRowMapper, id));
            return user;
        }
        catch (EmptyResultDataAccessException exception) {
            System.out.println("Юзер по id не найден");
        }
        return Optional.empty();
    }

    @Override
    public void save(User model) throws SQLException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, new String[] {"id"});
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getEmail());
            preparedStatement.setString(3,model.getPassword());
            preparedStatement.setString(4, model.getUuid());
            return preparedStatement;
        }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public void addBasketId(Long id, Long basketId) {
        jdbcTemplate.update(SQL_INSERT_BASKET_ID_COLUMN, basketId, id);
    }

}
