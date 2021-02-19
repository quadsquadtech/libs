package com.quadsquad.core;

public interface IReactiveCrudRepository<T, Id> extends IRepository<T, Id> {

    IObserver<T> save(T entity);

    IObserver<T> saveAll(Iterable<T> entities);

    IObserver<T> findById(Id id);

    IObserver<Boolean> existsById(Id id);

    IObserver<T> findAll();

    IObserver<T> findAllById(Iterable<Id> ids);

    IObserver<Long> count();

    IObserver<Boolean> deleteById(Id id);

    IObserver<Boolean> delete(T entity);

    IObserver<Boolean> deleteAll(Iterable<T> entities);

    IObserver<Boolean> deleteAll();
}
