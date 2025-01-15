package com.genaro.productosIt.repository;

import java.util.ArrayList;
import java.util.Optional;

public interface RepositoryI<T> {
    public T save(T entity);
    public void delete(T entity);
    public ArrayList<T> find(T query);
    public Optional<T> update(T query, T entity);
    public Optional<T> findOne(T query);
}
