//package com.merenaas.repositories;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//public interface UniversalCrudRepository {
//    <T> Optional<T> findOne(Long id, Class<? extends T> c);
//    <T> void save(T model) throws SQLException;
//    <T> void delete(Long id, Class<? extends T> c);
//    <T> List<T> findAll(Class<? extends T> c);
//}
