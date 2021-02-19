package com.ttmdaniel.core.abstracts;


public interface ICrudRepository<T, Id> extends IRepository<T, Id> {

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    T findById(Id id);

    boolean existsById(Id id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<Id> ids);

    long count();

    boolean deleteById(Id id);

    boolean delete(T entity);

    boolean deleteAll(Iterable<? extends T> entities);

    boolean deleteAll();
}
