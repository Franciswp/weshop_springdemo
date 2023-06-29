package com.example.demospring.data.dao;

import com.example.demospring.data.entities.CategoryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {
    private final EntityManager entityManager;

    @Autowired
    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addCategory(CategoryEntity toAdd) {
        entityManager.persist(toAdd);
    }

    public CategoryEntity update(CategoryEntity toUpdate) {
        return entityManager.merge(toUpdate);
    }



    public List<CategoryEntity> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> criteriaQuery = criteriaBuilder.createQuery(CategoryEntity.class);

        Root<CategoryEntity> root = criteriaQuery.from(CategoryEntity.class);
        criteriaQuery.select(root);

        TypedQuery query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
