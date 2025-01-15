package com.genaro.productosIt.repository;

import com.genaro.productosIt.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.Optional;

public abstract class AbstractRepository<T extends AbstractEntity> implements RepositoryI<T>{
    protected final ArrayList<T> entities = new ArrayList<>();

    @Override
    public T save(T entity) {
        entity.setId(T.getNewId());

        entities.add(entity);
        return entity;
    }

    @Override
    public void delete(T query) {
        T entity = findOne(query).orElse(null);

        if(entity != null){
            entities.remove(entity);
        }
    }

    @Override
    abstract public ArrayList<T> find(T query);

    @Override
    abstract public Optional<T> findOne(T query);

    @Override
    public Optional<T> update(T query, T entity) {
        T entityToUpdate = findOne(query).orElse(null);

        if(entityToUpdate != null){
            entity.setId(entityToUpdate.getId());

            entities.remove(entityToUpdate);
            entities.add(entity);

            return Optional.of(entityToUpdate);
        }

        return Optional.empty();
    }

}
