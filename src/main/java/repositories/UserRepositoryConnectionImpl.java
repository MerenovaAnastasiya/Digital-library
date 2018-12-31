//package repositories;
//
//import lombok.*;
//import mappers.RowMapper;
//import models.Order;
//import models.User;
//
//import java.sql.*;
//import java.util.*;
//
//public class UserRepositoryConnectionImpl implements UserRepository {
//    private Connection connection;
//
//    private Map<User, List<Order>> userWithOrdersMap;
//    private Map<Long, User> userIdWithOrdersMap;
//    private User theOnlyUser;
//
//    //language=SQL
//    private static final String SQL_INSERT_QUERY = "insert into library_user(first_name, last_name, address, phone_number, email)" +
//            "values (?, ?, ?, ?, ?);";
//    //language=SQL
//    private static final String SQL_DELETE_QUERY = "DELETE  FROM library_user where id = ?";
//
//    //language=SQL
//    private static final String SQL_SELECT_USER_WITH_ORDERS_BY_ID =
//            "SELECT \"order\".id AS order_id , * " +
//                    "FROM \"order\" JOIN library_user "+
//                    "ON library_user.id = \"order\".holder_id "+
//                    "WHERE library_user.id = ?;";
//
//    //language=SQL
//    private static final String SQL_SELECT_USERS_WITH_ORDERS =
//            "SELECT  \"order\".id AS order_id, * " +
//                    "FROM library_user " +
//                    "JOIN order ON library_user.id = \"order\".holder_id " +
//                    "\"order\" BY library_user.id;";
//    //language=SQL
//    private static final String SQL_SELECT_USER_BY_EMAIL =
//            "SELECT * FROM library_user WHERE email = ?";
//
//    public UserRepositoryConnectionImpl(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public List<User> findAllByFirstName(String firstName) {
//        return null;
//    }
//
//    @Override
//    @SneakyThrows
//    public Optional<User> findOneByEmail(String email) {
//        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
//        statement.setString(1, email);
//        ResultSet resultSet = statement.executeQuery();
//        if (!resultSet.next()) {
//            return Optional.empty();
//        }
//        return Optional.of(userWithoutOrdersRowMapper.rowMap(resultSet));
//    }
//    private RowMapper<User> userWithoutOrdersRowMapper = new RowMapper<User>() {
//        @Override
//        @SneakyThrows
//        public User rowMap(ResultSet resultSet) {
//            return User.builder()
//                    .email(resultSet.getString("email"))
//                    .address(resultSet.getString("address"))
//                    .firstName(resultSet.getString("first_name"))
//                    .lastName(resultSet.getString("last_name"))
//                    .id(resultSet.getLong("id"))
//                    .build();
//        }
//    };
//    private RowMapper<User> userWithOrdersForOneUserRowMapper = new RowMapper<User>() {
//        @Override
//        @SneakyThrows
//        public User rowMap(ResultSet resultSet) {
//            if (userWithOrdersMap.size() == 0) {
//                User newUser = userWithoutOrdersRowMapper.rowMap(resultSet);
//                userWithOrdersMap.put(newUser, new ArrayList<>());
//                theOnlyUser = newUser;
//            }
//            Order order = Order.builder()
//                    .id(resultSet.getLong("id"))
//                    .user(theOnlyUser)
//                    .dateOfIssue(resultSet.getTimestamp("date_of_issue").toLocalDateTime())
//                    .dateOfReturn(resultSet.getTimestamp("date_of_return").toLocalDateTime())
//                    .build();
//            userWithOrdersMap.get(theOnlyUser).add(order);
//            return theOnlyUser;
//        }
//    };
//
//    private RowMapper<User> userWithOrdersRowMapper = new RowMapper<User>() {
//        @Override
//        @SneakyThrows
//        public User rowMap(ResultSet resultSet) {
//            Long currentUserId = resultSet.getLong("id");
//            if (!userIdWithOrdersMap.containsKey(currentUserId)) {
//                User newUser = userWithoutOrdersRowMapper.rowMap(resultSet);
//                newUser.setOrders(new ArrayList<>());
//                userIdWithOrdersMap.put(currentUserId, newUser);
//            }
//            Order order = Order.builder()
//                    .id(resultSet.getLong("id"))
//                    .user(theOnlyUser)
//                    .dateOfIssue(resultSet.getTimestamp("date_of_issue").toLocalDateTime())
//                    .dateOfReturn(resultSet.getTimestamp("date_of_return").toLocalDateTime())
//                    .build();
//            User currentUser = userIdWithOrdersMap.get(currentUserId);
//            List<Order> ordersOfUser = currentUser.getOrders();
//            ordersOfUser.add(order);
//            return currentUser;
//        }
//    };
//
//
//
//    @Override
//    @SneakyThrows
//    public Optional<User> findOne(Long id) {
//        userWithOrdersMap = new HashMap<>();
//        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_WITH_ORDERS_BY_ID);
//        statement.setLong(1, id);
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            userWithOrdersForOneUserRowMapper.rowMap(resultSet);
//        }
//        theOnlyUser.setOrders(userWithOrdersMap.get(theOnlyUser));
//        User result = theOnlyUser;
//        theOnlyUser = null;
//        userWithOrdersMap.clear();
//        return Optional.of(result);
//    }
//
//    @Override
//    public void save(User model) throws SQLException {
//        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
//        statement.setString(1, model.getFirstName());
//        statement.setString(2, model.getLastName());
//        statement.setString(3, model.getAddress());
//        statement.setString(4, model.getPhoneNumber());
//        statement.setString(5, model.getEmail());
//        ResultSet resultSet = statement.getGeneratedKeys();
//        while (resultSet.next()) {
//            model.setId(resultSet.getLong("id"));
//        }
//        statement.executeUpdate();
//    }
//
//    @Override
//    @SneakyThrows
//    public void delete(Long id) {
//        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_QUERY);
//        statement.setLong(1, id);
//        statement.executeUpdate();
//
//    }
//
//    @Override
//    @SneakyThrows
//    public List<User> findAll() {
//        userIdWithOrdersMap = new HashMap<>();
//        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USERS_WITH_ORDERS);
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            userWithOrdersRowMapper.rowMap(resultSet);
//        }
//        return new ArrayList<>(userIdWithOrdersMap.values());
//    }
//
//
//}
