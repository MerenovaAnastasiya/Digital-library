//package com.merenaas.repositories;
//
//import com.merenaas.models.Book;
//import com.merenaas.models.Order;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component("orderRepository")
//public class OrderRepositoryJdbcTemplate implements OrderRepository {
//
//    private RowMapper<Book> bookRowMapper = (resultSet, i) -> Book.builder()
//            .id(resultSet.getLong("book_id"))
//            .bookName(resultSet.getString("book_name"))
//            .author(resultSet.getString("author"))
//            .path(resultSet.getString("path"))
//            .description(resultSet.getString("description"))
//            .build();
//
//
//    private JdbcTemplate jdbcTemplate;
//
//    public OrderRepositoryJdbcTemplate(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    //language=SQL
//    String SQL_SELECT_ORDER_WITH_BOOKS = "SELECT \"order\".id, book_id, address, " +
//            "date, user_first_name, user_last_name, phone, " +
//            "\"order\".email, comment, book_name, author, b.path, " +
//            "b.description FROM \"order\" JOIN order_book o on " +
//            "\"order\".id = o.order_id JOIN book b ON o.book_id = b.id JOIN " +
//            "library_user u on \"order\".library_user_id = u.id WHERE \"order\".id = ?;\n";
//    //language=SQL
//    String SQL_FIND_ALL_BOOKS_FROM_ORDER = "SELECT book_id, book_name, author," +
//            "b.path, b.description FROM \"order\" JOIN order_book o" +
//            "on \"order\".id = o.order_id JOIN book b ON o.book_id = b.id" +
//            "JOIN library_user u on \"order\".library_user_id = u.id WHERE \"order\".id = ?";
//
//    //language=SQL
//    String SQL_INSERT_INTO_ORDER_BOOK = "INSERT INTO order_book (order_id, book_id) VALUES (?, ?);";
//
//    //language=SQL
//    String SQL_INSERT_INTO_ORDER = "INSERT INTO \"order\" (" +
//            "id, library_user_id, address," +
//            "date, user_first_name, user_last_name, phone, email, comment)" +
//            "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?);";
//
//
//    //TODO убрать connection это что ваще такое!!!!!
////    @Override
////    public Optional<Order> findOne(Long id) {
////        try {
////            PreparedStatement preparedStatement = jdbcTemplateconnection.prepareStatement(SQL_SELECT_ORDER_WITH_BOOKS);
////            preparedStatement.setLong(1, id);
////            if (preparedStatement.execute()) {
////                ResultSet resultSet = preparedStatement.getResultSet();
////                List<Book> bookList = new ArrayList<>();
////                Order order = null;
////                while (resultSet.next()) {
////                    if (order == null) {
////                        order = Order.builder()
////                                .id(resultSet.getLong("id"))
////                                .address(resultSet.getString("address"))
////                                .date(resultSet.getObject("date", LocalDate.class))
////                                .userFirstName("user_first_name")
////                                .userLastName("user_last_name")
////                                .phone("phone")
////                                .email("email")
////                                .comment("comment")
////                                .build();
////                    }
////                    Book book = Book.builder()
////                            .id(resultSet.getLong("book_id"))
////                            .bookName("book_name")
////                            .author("author")
////                            .path("path")
////                            .description("description")
////                            .build();
////                    bookList.add(book);
////                }
////                if (order != null) {
////                    order.setBookList(bookList);
////                    return Optional.of(order);
////                }
////            }
////            return Optional.empty();
////        } catch (SQLException e) {
////            throw new IllegalArgumentException();
////        }
////
////
////    }
//
//
//    @Override
//    public Optional<Order> findOne(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void save(Order model) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_ORDER, new String[]{"id"});
//            preparedStatement.setLong(1, model.getUser().getId());
//            preparedStatement.setString(2, model.getAddress());
//            preparedStatement.setDate(3, Date.valueOf(model.getDate()));
//            preparedStatement.setString(4, model.getUserFirstName());
//            preparedStatement.setString(5, model.getUserLastName());
//            preparedStatement.setString(6, model.getPhone());
//            preparedStatement.setString(7, model.getEmail());
//            preparedStatement.setString(8, model.getComment());
//            return preparedStatement;
//        }, keyHolder);
//        model.setId(keyHolder.getKey().longValue());
//
//    }
//
//    @Override
//    public void delete(Long id) {
//    }
//
//    @Override
//    public List<Order> findAll() {
//        return null;
//    }
//
//
//    @Override
//    public void saveOrder(List<Book> bookList, Order order) {
//        for (Book book : bookList) {
//            jdbcTemplate.update(SQL_INSERT_INTO_ORDER_BOOK, order.getId(), book.getId());
//        }
//    }
//}
