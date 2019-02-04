package com.usuario.usuario.service;

import java.util.List;
import java.util.Optional;

import com.usuario.usuario.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<Entity, Repository extends JpaRepository<Entity, Long>> {

    @Autowired
    private Repository repository;

    public List<Entity> findAll() {
        return repository.findAll();
    }

    public Entity findById(Long id) {
        Optional<Entity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    public Entity save(Entity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List<Entity> save(Iterable<Entity> entities) {
        try {
            return repository.saveAll(entities);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public Entity update(Entity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public List<Entity> update(Iterable<Entity> entities) {
        try {
            return repository.saveAll(entities);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public void delete(List<Entity> entities) {
        try {
            repository.deleteAll(entities);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    public Repository getRepository() {
        return repository;
    }

}
