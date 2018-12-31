package repositories;

import lombok.SneakyThrows;
import models.Basket;
import models.Book;
import models.Order;
import models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class BasketRepositoryJdbcTemplateImpl implements BasketRepository {


    private JdbcTemplate jdbcTemplate;
    private Map<Basket, List<Book>> basketWithBooksMap = new HashMap<>();
    private Basket theOnlyBasket;

    public BasketRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_SELECT_BASKET_WITH_BOOKS_BY_ID =
            "SELECT * FROM basket_book JOIN book ON basket_book.book_id = book.id WHERE basket_id = ?;";

    //language=SQL
    private static final String SQL_ADD_PRODUCT_TO_BASKET = "INSERT INTO basket_book(basket_id, book_id) VALUES (?, ?);";
    //language=SQL
    private static final String SQL_INSERT = "INSERT INTO basket(id) VALUES (DEFAULT);";
    //language=SQL
    private static final String SQL_DELETE = "DELETE FROM basket_book WHERE basket_book.basket_id = ?;";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_ID_WITHOUT_BOOKS =
                "SELECT b.id, u.id AS user_id, u.phone_number, u.email, u.password, u.login, u.uuid FROM " +
                    "basket b JOIN library_user u on b.id = u.basket_id WHERE b.id = ?;";

    //language=SQL
    private static final String SQL_FIND_ONE_BY_ID =
    "SELECT bs.id, phone_number, email, us.password,\n" +
            "us.login, us.uuid, bs.user_id, basket_book.book_id, book_name, author, b.path, b.description\n" +
            "FROM library_user us JOIN basket bs ON bs.id = us.basket_id\n" +
            "LEFT JOIN basket_book ON basket_book.basket_id = bs.id\n" +
            "LEFT JOIN book b ON b.id = basket_book.book_id WHERE bs.id = ?;";
    //language=SQL
    private static final String SQL_INSERT_USER_ID_COLUMN = "UPDATE basket SET user_id = ? WHERE id = ?;";

    //language=SQL
    private static final  String SQL_FIND_ONE_BY_USER_ID = "SELECT b.id, u.id AS user_id, u.phone_number, u.email, u.password, u.login, u.uuid FROM basket b JOIN library_user u on b.id = u.basket_id WHERE u.id = ?;";

    private RowMapper<Basket> basketWithoutBooksRowMapper = new RowMapper<Basket>() {
        @Override
        @SneakyThrows
        public Basket mapRow(ResultSet resultSet, int rowNum) {
            Basket basket = Basket.builder()
                    .id(resultSet.getLong("id"))
                    .build();
            User user = User.builder()
                    .id(resultSet.getLong("user_id"))
                    .login(resultSet.getString("login"))
                    .phoneNumber(resultSet.getString("phone_number"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .uuid(resultSet.getString("uuid"))
                    .basket(basket)
                    .build();
            basket.setUser(user);
            return basket;
        }
    };
    private RowMapper<Basket> basketWithBooksRowMapper = new RowMapper<Basket>() {
        @Override
        @SneakyThrows
        public Basket mapRow(ResultSet resultSet, int rowNum) {
            // если пользователь еще не был добавлен
            if (basketWithBooksMap.size() == 0) {
                // отображаем строку resultSet в объект
                Basket newBasket = basketWithoutBooksRowMapper.mapRow(resultSet, rowNum);
                // кладем этот объект в мап
                basketWithBooksMap.put(newBasket, new ArrayList<>());
                // запоминаем его (он единственный)
                theOnlyBasket = newBasket;
            }
            // вытаскиваем заказ
            Book book = Book.builder()
                    .id(resultSet.getLong("book_id"))
                    .bookName(resultSet.getString("book_name"))
                    .author(resultSet.getString("author"))
                    .path(resultSet.getString("path"))
                    .description(resultSet.getString("description"))
                    .build();
            basketWithBooksMap.get(theOnlyBasket).add(book);
            return theOnlyBasket;
        }
    };


    @Override
    public void addProductToBasket(Long basketId, Long bookId) {
        jdbcTemplate.update(SQL_ADD_PRODUCT_TO_BASKET, basketId, bookId);
    }

    @Override
    public Optional<Basket> findOneByUserId(Long id) {
        return Optional.empty();
    }

    @Override
    public void addUserId(Long id, Long userId) {
        jdbcTemplate.update(SQL_INSERT_USER_ID_COLUMN, userId, id);
    }

    @Override
    public Optional<Basket> getBasketWithBooks(Long id) {
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<Basket> findOne(Long id) {

        List<Basket> basketList = jdbcTemplate.query(SQL_FIND_ONE_BY_ID, basketWithBooksRowMapper, id);
            Basket currentBasket = theOnlyBasket;
            theOnlyBasket = null;
            currentBasket.setBooks(basketWithBooksMap.get(currentBasket));
            basketWithBooksMap = new HashMap<>();
            return Optional.of(currentBasket);

    }

    @Override
    public void save(Basket model) throws SQLException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            return statement;
        }, keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

    @Override
    public List<Basket> findAll() {
        return null;
    }
}



